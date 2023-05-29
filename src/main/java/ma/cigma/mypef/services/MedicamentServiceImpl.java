package ma.cigma.mypef.services;

import ma.cigma.mypef.dtos.MedicamentDto;
import ma.cigma.mypef.entities.MedicamentEntity;
import ma.cigma.mypef.mapper.Mapper_class;
import ma.cigma.mypef.repositories.MedicamentRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("medicament_service")
public class MedicamentServiceImpl implements MedicamentService{
    public MedicamentRepository repository;
    public Mapper_class mapper= Mappers.getMapper(Mapper_class.class);

    public MedicamentServiceImpl(@Qualifier("medicament_repo") MedicamentRepository repository) {
        this.repository = repository;
    }

    //ajouter medicament
    @Override
    public String create(MedicamentDto dto) {
        MedicamentDto obj =mapper.convertMedicamentEntitytoDto(repository.findByLibelle(dto.getLibelle()));
        if(obj ==null){
            mapper.convertMedicamentEntitytoDto(repository.save(mapper.convertMedicamentDtotoEntity(obj)));
            return "Le médicament a été ajouté avec succès";
        }
        else
            return "Le medicament est deja existe";

    }
    //modifier medicament
    @Override
    public String update(MedicamentDto dto) {
        MedicamentDto obj =mapper.convertMedicamentEntitytoDto(repository.findByLibelle(dto.getLibelle()));
        if(obj !=null){
            dto.setId(obj.getId());
            mapper.convertMedicamentEntitytoDto(repository.save(mapper.convertMedicamentDtotoEntity(dto)));
            return "Le médicament a été modifié avec succès";
        }
        else
            return "Le medicament n'existe pas";
    }
    //supprimer medicament by id
    @Override
    public String delete(String libelle) {
        MedicamentDto obj = mapper.convertMedicamentEntitytoDto(repository.findByLibelle(libelle));
        if(obj != null){
            repository.deleteById(obj.getId());
            return "Le médicament a été supprimer avec succès";
        }
        else
            return "Le medicament n'existe pas";
    }
    //afficher list des medicament
    @Override
    public List<MedicamentDto> readAll() {
        return mapper.convertMedicamentEntitiestoDtos(repository.findAll());
    }
    //afficher medicament by libelle
    @Override
    public String findByLibelle(String libelle) {
        MedicamentDto dto = mapper.convertMedicamentEntitytoDto(repository.findByLibelle(libelle));
        if(dto != null)
            return dto.toString();
        else
            return "ce medicament n'existe pas";
    }
}
