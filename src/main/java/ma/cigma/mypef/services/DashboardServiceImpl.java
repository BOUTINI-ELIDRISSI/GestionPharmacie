package ma.cigma.mypef.services;

import ma.cigma.mypef.dtos.EntreeDto;
import ma.cigma.mypef.dtos.FactureDto;
import ma.cigma.mypef.dtos.MedicamentDto;
import ma.cigma.mypef.dtos.SortieDto;
import ma.cigma.mypef.mapper.Mapper_class;
import ma.cigma.mypef.repositories.*;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service("dash_service")
public class DashboardServiceImpl implements DashboardService{
    public SortieRepository sortieRepository;
    public EntreeRepository entreeRepository;
    public MedicamentRepository medicamentRepository;
    public ClientRepository clientRepository;
    public FactureRepository factureRepository;
    public Mapper_class mapper= Mappers.getMapper(Mapper_class.class);


    public DashboardServiceImpl(@Qualifier("sortie_repo") SortieRepository sortieRepository,@Qualifier("entree_repo") EntreeRepository entreeRepository,
                                @Qualifier("medicament_repo")MedicamentRepository medicamentRepository,@Qualifier("client_repo") ClientRepository clientRepository,
                                @Qualifier("fact_repo") FactureRepository factureRepository) {
        this.sortieRepository = sortieRepository;
        this.entreeRepository = entreeRepository;
        this.medicamentRepository = medicamentRepository;
        this.clientRepository = clientRepository;
        this.factureRepository=factureRepository;
    }

    @Override
    public String Vente_J() {
        float sum = 0;
        //find current day of month
        LocalDate currentDate = LocalDate.now();
        int currentDay = currentDate.getDayOfMonth();

        List<FactureDto> factures = mapper.convertFactEntitiestoDtos(factureRepository.findAll());
        //calcul vente de jour

        for (FactureDto facture : factures) {
            Date factureDate = facture.getDate_Fact();
            LocalDate factureLocalDate = factureDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int factureDay = factureLocalDate.getDayOfMonth();

            if (factureDay == currentDay) {
                // Facture is on the current day
                // Perform your desired operations here
                sum += facture.getPrix_total();
            }
        }
       return sum + " DH";
    }

    @Override
    public String  Vente_M() {
        float sum = 0;
        //find current month
        LocalDate currentDate = LocalDate.now();
        int  currentMonth = currentDate.getMonthValue();

        //calcul vente de mois

        List<FactureDto> factures = mapper.convertFactEntitiestoDtos(factureRepository.findAll());

        for (FactureDto facture : factures) {
            Date factureDate = facture.getDate_Fact();
            LocalDate factureLocalDate = factureDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int factureMonth = factureLocalDate.getMonthValue();

            if (factureMonth == currentMonth) {
                // Facture is in the current month
                // Perform your desired operations here
                sum += facture.getPrix_total();
            }
        }
        return  sum + " DH";
    }

    @Override
    public String Vente_T() {
        float sum = 0;
        for (int i = 0; i < factureRepository.findAll().size(); i++){
            sum+=factureRepository.findAll().get(i).getPrix_total();
        }
        return sum +" DH";
    }

    @Override
    public int Nombre_Client() {
        return clientRepository.findAll().size();
    }

    @Override
    public int Nombre_Medicament() {
        return medicamentRepository.findAll().size();
    }

    @Override
    public int Medicament_Qte_Expire() {

        int qte_ex = 0;

        List<EntreeDto> entree = mapper.convertEntreeEntitiestoDtos(entreeRepository.findAll());
        List<MedicamentDto> medicament = mapper.convertMedicamentEntitiestoDtos(medicamentRepository.findAll());
        List<SortieDto> sortie = mapper.convertSortieEntitiestoDtos(sortieRepository.findAll());

        for(MedicamentDto med : medicament) {
            int qte_e = 0, qte_s = 0;
            for (int i = 0; i < entree.size(); i++) {
                if (entree.get(i).getMedicament().getId() == med.getId())
                    qte_e += entree.get(i).getQuantite();
            }
            for (int i = 0; i < sortie.size(); i++) {
                if (sortie.get(i).getMedicament().getId() == med.getId())
                    qte_s += sortie.get(i).getQuantite();
            }
            if ((qte_e - qte_s) <= 0)
                qte_ex+=1;
        }
        return qte_ex;
    }

    @Override
    public int Medicament_Date_Expire() {
        //declaration de quantite ecxpire
        int qte_ex = 0;
        //declaration de current date
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();


        List<MedicamentDto> medicament = mapper.convertMedicamentEntitiestoDtos(medicamentRepository.findAll());
        List<EntreeDto> entree = mapper.convertEntreeEntitiestoDtos(entreeRepository.findAll());


        EntreeDto dto ;



        for (MedicamentDto med : medicament){
            Date max =null;
            long id = 0;
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
            if(dto.getDate_expiration().compareTo(currentDate) <= 0)
                qte_ex+=1;
        }

        return qte_ex ;
    }

    @Override
    public int Nombe_Entree_J() {
        int sum = 0;
        //find current day of month
        LocalDate currentDate = LocalDate.now();
        int currentDay = currentDate.getDayOfMonth();

        List<EntreeDto> entreeDtos = mapper.convertEntreeEntitiestoDtos(entreeRepository.findAll());


        for (EntreeDto entree : entreeDtos) {
            Date entreeDate = entree.getDate_entree();
            LocalDate entreeLocalDate = entreeDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int entreeDay = entreeLocalDate.getDayOfMonth();

            if (entreeDay == currentDay) {

                sum += 1;
            }
        }

        return sum;
    }
}
