package ma.cigma.mypef.services;

import ma.cigma.mypef.dtos.FactureDto;
import ma.cigma.mypef.mapper.Mapper_class;
import ma.cigma.mypef.repositories.FactureRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("fact_service")
public class FactureServiceImpl implements FactureService{

    public FactureRepository repository;
    public Mapper_class mapper= Mappers.getMapper(Mapper_class.class);

    public FactureServiceImpl(@Qualifier("fact_repo") FactureRepository repository) {
        this.repository = repository;
    }

    @Override
    public Long create(FactureDto dto) {
        return mapper.convertFactEntitytoDto(repository.save(mapper.convertFactDtotoEntity(dto))).getCode();
    }

    @Override
    public Long update(FactureDto dto) {
        return mapper.convertFactEntitytoDto(repository.save(mapper.convertFactDtotoEntity(dto))).getCode();
    }

    @Override
    public boolean delete(long id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<FactureDto> readAll() {
        return mapper.convertFactEntitiestoDtos(repository.findAll());
    }
}
