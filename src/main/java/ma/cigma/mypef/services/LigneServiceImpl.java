package ma.cigma.mypef.services;

import ma.cigma.mypef.dtos.LigneDto;
import ma.cigma.mypef.dtos.LigneKeyDto;
import ma.cigma.mypef.mapper.Mapper_class;
import ma.cigma.mypef.repositories.LigneRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ligne_service")
public class LigneServiceImpl implements LigneService{
    public LigneRepository repository;
    public Mapper_class mapper= Mappers.getMapper(Mapper_class.class);

    public LigneServiceImpl(@Qualifier("ligne_repo") LigneRepository repository) {
        this.repository = repository;
    }

    @Override
    public Long create(LigneDto dto) {
        return mapper.convertLigneEntitytoDto(repository.save(mapper.convertLigneDtotoEntity(dto))).getId().getCmdcode();
    }

    @Override
    public Long update(LigneDto dto) {
        return mapper.convertLigneEntitytoDto(repository.save(mapper.convertLigneDtotoEntity(dto))).getId().getCmdcode();
    }

    @Override
    public boolean delete(LigneKeyDto key) {
       repository.deleteById(mapper.LigneKeyDtoToEntity(key));
        return true;
    }

    @Override
    public List<LigneDto> readAll() {
        return mapper.convertLigneEntitiestoDtos(repository.findAll());
    }
}
