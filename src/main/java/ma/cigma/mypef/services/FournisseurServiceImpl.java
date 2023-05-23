package ma.cigma.mypef.services;

import ma.cigma.mypef.dtos.FournisseurDto;
import ma.cigma.mypef.mapper.Mapper_class;
import ma.cigma.mypef.repositories.FactureRepository;
import ma.cigma.mypef.repositories.FournisseurRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("fournisseur_service")
public class FournisseurServiceImpl implements FournisseurService{
    public FournisseurRepository repository;
    public Mapper_class mapper= Mappers.getMapper(Mapper_class.class);

    public FournisseurServiceImpl(@Qualifier("fournisseur_repo") FournisseurRepository repository) {
        this.repository = repository;
    }


    @Override
    public Long create(FournisseurDto dto) {
        return mapper.convertFournisseurEntitytoDto(repository.save(mapper.convertFournisseurDtotoEntity(dto))).getId();
    }

    @Override
    public Long update(FournisseurDto dto) {
        return mapper.convertFournisseurEntitytoDto(repository.save(mapper.convertFournisseurDtotoEntity(dto))).getId();
    }

    @Override
    public boolean delete(long id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<FournisseurDto> readAll() {
        return mapper.convertFournisseurEntitiestoDtos(repository.findAll());
    }
}
