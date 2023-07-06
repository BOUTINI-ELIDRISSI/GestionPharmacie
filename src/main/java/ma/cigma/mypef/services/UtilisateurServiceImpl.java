package ma.cigma.mypef.services;

import ma.cigma.mypef.dtos.RoleDto;
import ma.cigma.mypef.dtos.UtilisateurDto;
import ma.cigma.mypef.mapper.Mapper_class;
import ma.cigma.mypef.repositories.RoleRepository;
import ma.cigma.mypef.repositories.UtilisateurRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service("user_service")
public class UtilisateurServiceImpl implements UtilisateurService{
    public UtilisateurRepository repository;
    public RoleRepository roleRepository;
    public Mapper_class mapper= Mappers.getMapper(Mapper_class.class);

    public UtilisateurServiceImpl(@Qualifier("user_repo") UtilisateurRepository repository, @Qualifier("role_repo") RoleRepository roleRepository) {
        this.repository = repository;
        this.roleRepository=roleRepository;
    }

    @Override
    public String create(UtilisateurDto dto) {
        UtilisateurDto user = mapper.convertUserEntitytoDto(repository.findByNom(dto.getNom()));
        if(user == null){
            mapper.convertUserEntitytoDto(repository.save(mapper.convertUserDtotoEntity(dto)));
            return "L'utilisateur a été ajouté avec succès";
        }
        else
            return "";
    }

    @Override
    public String  update(UtilisateurDto dto) {
        UtilisateurDto user = mapper.convertUserEntitytoDto(repository.findByNom(dto.getNom()));
        if(user != null){
            mapper.convertUserEntitytoDto(repository.save(mapper.convertUserDtotoEntity(dto)));
            return "";
        }
        else
            return "";
    }

    @Override
    public String delete(long id) {
        repository.deleteById(id);
        return "";
    }

    @Override
    public List<UtilisateurDto> readAll() {
        return mapper.convertUserEntitiestoDtos(repository.findAll());
    }

    @Override
    public List<UtilisateurDto> findbyRole(String roleNom) {
        RoleDto role = mapper.convertRoleEntitytoDto(roleRepository.findByNom(roleNom));
        if (role != null)
            return mapper.convertUserEntitiestoDtos(repository.findByRole(mapper.convertRoleDtotoEntity(role)));
        else
            return Collections.emptyList();

    }

    @Override
    public UtilisateurDto findByNom(String nom) {
        return mapper.convertUserEntitytoDto(repository.findByNom(nom));
    }

    @Override
    public UtilisateurDto findByEmail(String email) {
        return mapper.convertUserEntitytoDto(repository.findByEmail(email));
    }
}
