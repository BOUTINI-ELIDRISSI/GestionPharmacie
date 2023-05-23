package ma.cigma.mypef.services;

import ma.cigma.mypef.dtos.MedicamentDto;
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

    @Override
    public Long create(MedicamentDto dto) {
        return mapper.convertMedicamentEntitytoDto(repository.save(mapper.convertMedicamentDtotoEntity(dto))).getId();
    }

    @Override
    public Long update(MedicamentDto dto) {
        return mapper.convertMedicamentEntitytoDto(repository.save(mapper.convertMedicamentDtotoEntity(dto))).getId();
    }

    @Override
    public boolean delete(long id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<MedicamentDto> readAll() {
        return mapper.convertMedicamentEntitiestoDtos(repository.findAll());
    }
}
