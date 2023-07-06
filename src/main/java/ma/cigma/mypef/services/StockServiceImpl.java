package ma.cigma.mypef.services;

import ma.cigma.mypef.dtos.*;
import ma.cigma.mypef.mapper.Mapper_class;
import ma.cigma.mypef.repositories.EntreeRepository;
import ma.cigma.mypef.repositories.LigneRepository;
import ma.cigma.mypef.repositories.MedicamentRepository;
import ma.cigma.mypef.repositories.SortieRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service("stock_service")
public class StockServiceImpl implements StockService{
    public MedicamentRepository medicamentRepository;
    public EntreeRepository entreeRepository;
    public SortieRepository sortieRepository;
    public LigneRepository ligneRepository;
    public Mapper_class mapper = Mappers.getMapper(Mapper_class.class);

    private JavaMailSender mailSender;

    public StockServiceImpl(JavaMailSender mailSender,MedicamentRepository medicamentRepository, EntreeRepository entreeRepository, SortieRepository sortieRepository, LigneRepository ligneRepository) {
        this.medicamentRepository = medicamentRepository;
        this.entreeRepository = entreeRepository;
        this.sortieRepository = sortieRepository;
        this.ligneRepository = ligneRepository;
        this.mailSender=mailSender;
    }

    @Override
    public List<Stock> list_Stock() {
        List<Stock> lst =new ArrayList<>();

        List<EntreeDto> entree = mapper.convertEntreeEntitiestoDtos(entreeRepository.findAll());
        List<MedicamentDto> medicament = mapper.convertMedicamentEntitiestoDtos(medicamentRepository.findAll());
        List<SortieDto> sortie = mapper.convertSortieEntitiestoDtos(sortieRepository.findAll());
        List<LigneDto> ligne = mapper.convertLigneEntitiestoDtos(ligneRepository.findAll());


        int qte = 0;
       // Calendar calendar = Calendar.getInstance();
       // Date currentDate = calendar.getTime();

        for(MedicamentDto med : medicament) {
            // count the qte
            int qte_e = 0, qte_s = 0, qte_l = 0;
            for (int i = 0; i < entree.size(); i++) {
                if (entree.get(i).getMedicament().getId() == med.getId())
                    qte_e += entree.get(i).getQuantite();
            }
            for (int i = 0; i < sortie.size(); i++) {
                if (sortie.get(i).getMedicament().getId() == med.getId())
                    qte_s += sortie.get(i).getQuantite();
            }
            for (int i = 0; i < ligne.size(); i++) {
                if (ligne.get(i).getMedicament().getId() == med.getId())
                    qte_l += ligne.get(i).getQuantite();
            }

            qte = qte_e - (qte_s + qte_l);
            if (qte < 0)
                qte = 0;
            //found the date d'expiration
            Date max =null;
            long id = 0;
            EntreeDto dto;
            for (int i = 0; i < entree.size(); i++)
            {
                if (entree.get(i).getMedicament().getId() == med.getId()){
                    if (max == null) {
                        max = entree.get(i).getDate_entree();
                        id = entree.get(i).getId();
                    }
                    else {
                        if(max.compareTo(entree.get(i).getDate_entree()) < 0){
                            max = entree.get(i).getDate_entree();
                            id = entree.get(i).getId();
                        }
                    }

                }
            }
            dto=mapper.convertEntreeEntitytoDto(entreeRepository.findById(id));

            // insert int stock list
            lst.add(new Stock(med.getId(),med.getLibelle(),dto.getDate_expiration(),dto.getFournisseur().getNom(),qte));
        }

        return lst;
    }

    ///send Email
    public String  sendEmail(String toEmail, String subject,String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ikrambe089@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        mailSender.send(message);
        return "";
    }
}
