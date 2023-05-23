package ma.cigma.mypef.services;

import ma.cigma.mypef.dtos.EntreeDto;
import ma.cigma.mypef.mapper.Mapper_class;
import ma.cigma.mypef.repositories.EntreeRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("entree_service")
public class EntreeServiceImpl implements EntreeService{
    public EntreeRepository entreeRepository;
    public Mapper_class mapper= Mappers.getMapper(Mapper_class.class);

    public EntreeServiceImpl(@Qualifier("entree_repo") EntreeRepository entreeRepository) {
        this.entreeRepository = entreeRepository;
    }

    @Override
    public Long create(EntreeDto dto) {
        return mapper.convertEntreeEntitytoDto(entreeRepository.save(mapper.convertEntreeDtotoEntity(dto))).getId();
    }

    @Override
    public Long update(EntreeDto dto) {
        return mapper.convertEntreeEntitytoDto(entreeRepository.save(mapper.convertEntreeDtotoEntity(dto))).getId();
    }

    @Override
    public boolean delete(long id) {
        entreeRepository.deleteById(id);
        return true;
    }

    @Override
    public List<EntreeDto> readAll() {
        return mapper.convertEntreeEntitiestoDtos(entreeRepository.findAll());
    }
}
