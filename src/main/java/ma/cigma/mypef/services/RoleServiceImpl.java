package ma.cigma.mypef.services;

import ma.cigma.mypef.dtos.RoleDto;
import ma.cigma.mypef.mapper.Mapper_class;
import ma.cigma.mypef.repositories.RoleRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("role_service")
public class RoleServiceImpl implements RoleService{
    public RoleRepository repository;
    public Mapper_class mapper= Mappers.getMapper(Mapper_class.class);

    public RoleServiceImpl(@Qualifier("role_repo") RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Long create(RoleDto dto) {
        return mapper.convertRoleEntitytoDto(repository.save(mapper.convertRoleDtotoEntity(dto))).getId();
    }
    @Override
    public Long update(RoleDto dto) {
        return mapper.convertRoleEntitytoDto(repository.save(mapper.convertRoleDtotoEntity(dto))).getId();
    }

    @Override
    public boolean delete(long id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<RoleDto> readAll() {
        return mapper.convertRoleEntitiestoDtos(repository.findAll());
    }
}
