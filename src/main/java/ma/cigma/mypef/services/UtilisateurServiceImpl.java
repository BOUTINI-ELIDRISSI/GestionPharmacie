package ma.cigma.mypef.services;

import ma.cigma.mypef.dtos.UtilisateurDto;
import ma.cigma.mypef.mapper.Mapper_class;
import ma.cigma.mypef.repositories.UtilisateurRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("user_service")
public class UtilisateurServiceImpl implements UtilisateurService{
    public UtilisateurRepository repository;
    public Mapper_class mapper= Mappers.getMapper(Mapper_class.class);

    public UtilisateurServiceImpl(@Qualifier("user_repo") UtilisateurRepository repository) {
        this.repository = repository;
    }

    @Override
    public Long create(UtilisateurDto dto) {
        return mapper.convertUserEntitytoDto(repository.save(mapper.convertUserDtotoEntity(dto))).getId();
    }

    @Override
    public Long update(UtilisateurDto dto) {
        return mapper.convertUserEntitytoDto(repository.save(mapper.convertUserDtotoEntity(dto))).getId();
    }

    @Override
    public boolean delete(long id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<UtilisateurDto> readAll() {
        return mapper.convertUserEntitiestoDtos(repository.findAll());
    }
}
