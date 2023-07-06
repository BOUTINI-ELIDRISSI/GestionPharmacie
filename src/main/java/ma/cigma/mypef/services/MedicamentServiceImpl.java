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
        //MedicamentDto obj =mapper.convertMedicamentEntitytoDto(repository.findByLibelle(dto.getLibelle()));
        //if(obj ==null){
            mapper.convertMedicamentEntitytoDto(repository.save(mapper.convertMedicamentDtotoEntity(dto)));
            return "";
        //}
       // else
          //  return "Le medicament est deja existe";

    }
    //modifier medicament
    @Override
    public String update(MedicamentDto dto) {
        MedicamentDto obj =mapper.convertMedicamentEntitytoDto(repository.findByLibelle(dto.getLibelle()));
        if(obj !=null){
            dto.setId(obj.getId());
            mapper.convertMedicamentEntitytoDto(repository.save(mapper.convertMedicamentDtotoEntity(dto)));
            return "";
        }
        else
            return "";
    }
    //supprimer medicament by id
    @Override
    public String delete(long id) {

            repository.deleteById(id);
            return "";

    }
    //afficher list des medicament
    @Override
    public List<MedicamentDto> readAll() {
        return mapper.convertMedicamentEntitiestoDtos(repository.findAll());
    }
    //afficher medicament by libelle
    @Override
    public MedicamentDto findByLibelle(String libelle) {
        return mapper.convertMedicamentEntitytoDto(repository.findByLibelle(libelle));

    }
}
