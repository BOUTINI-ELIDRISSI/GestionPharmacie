package ma.cigma.mypef.services;

import ma.cigma.mypef.dtos.*;
import ma.cigma.mypef.mapper.Mapper_class;
import ma.cigma.mypef.repositories.LigneRepository;
import ma.cigma.mypef.repositories.MedicamentRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ligne_service")
public class LigneServiceImpl implements LigneService{
    public LigneRepository repository;
    public MedicamentRepository medicamentRepository;
    public Mapper_class mapper= Mappers.getMapper(Mapper_class.class);

    public LigneServiceImpl(@Qualifier("ligne_repo") LigneRepository repository, @Qualifier("medicament_repo")MedicamentRepository medicamentRepository) {
        this.repository = repository;
        this.medicamentRepository=medicamentRepository;
    }

    @Override
    public String create(LigneDto dto) {
        boolean exist = false;
        List<LigneDto> lst=mapper.convertLigneEntitiestoDtos(repository.findByMedicament(mapper.convertMedicamentDtotoEntity(dto.getMedicament())));
        for(int i = 0; i < lst.size(); i++){
            if(lst.get(i).getCommande().getCode() == dto.getCommande().getCode())
                exist =true;
        }
        if(!exist){

            mapper.convertLigneEntitytoDto(repository.save(mapper.convertLigneDtotoEntity(dto)));
            return "le médicament a été ajouté à la commande";
        }
        else
            return "Le médicament est déjà à la commande";
    }

    @Override
    public String update(LigneDto dto) {
        boolean exist = false;
        List<LigneDto> lst=mapper.convertLigneEntitiestoDtos(repository.findByMedicament(mapper.convertMedicamentDtotoEntity(dto.getMedicament())));
        for(int i = 0; i < lst.size(); i++){
            if(lst.get(i).getCommande().getCode() == dto.getCommande().getCode())
                exist =true;
        }
        if(exist){

            mapper.convertLigneEntitytoDto(repository.save(mapper.convertLigneDtotoEntity(dto)));
            return "le médicament a été modifié à la commande";
        }
        else
            return "Le médicament n'existe pas";
    }

    @Override
    public boolean delete(String libelle, long code) {
        MedicamentDto medicament = mapper.convertMedicamentEntitytoDto(medicamentRepository.findByLibelle(libelle));
        LigneKeyDto key =new LigneKeyDto(medicament.getId(), code);
       repository.deleteById(mapper.LigneKeyDtoToEntity(key));
        return true;
    }

    @Override
    public List<LigneDto> readAll() {
        return mapper.convertLigneEntitiestoDtos(repository.findAll());
    }

    @Override
    public List<LigneDto> findByCommand(long cmdCode) {
        CommandeDto cmd=new CommandeDto();
        cmd.setCode(cmdCode);
        return mapper.convertLigneEntitiestoDtos(repository.findByCommande(mapper.convertCmdDtotoEntity(cmd)));
    }

    @Override
    public List<LigneDto> findByMedicament(String libelle) {
        MedicamentDto medicament = mapper.convertMedicamentEntitytoDto(medicamentRepository.findByLibelle(libelle));
        return mapper.convertLigneEntitiestoDtos(repository.findByMedicament(mapper.convertMedicamentDtotoEntity(medicament)));
    }
}
