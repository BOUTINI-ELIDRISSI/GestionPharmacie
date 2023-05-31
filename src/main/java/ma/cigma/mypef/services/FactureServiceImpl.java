package ma.cigma.mypef.services;

import ma.cigma.mypef.dtos.FactureDto;
import ma.cigma.mypef.dtos.UtilisateurDto;
import ma.cigma.mypef.mapper.Mapper_class;
import ma.cigma.mypef.repositories.FactureRepository;
import ma.cigma.mypef.repositories.UtilisateurRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("fact_service")
public class FactureServiceImpl implements FactureService{

    public FactureRepository repository;
    public UtilisateurRepository utilisateurRepository;
    public Mapper_class mapper= Mappers.getMapper(Mapper_class.class);

    public FactureServiceImpl(@Qualifier("fact_repo") FactureRepository repository, @Qualifier("user_repo")UtilisateurRepository utilisateurRepository) {
        this.repository = repository;
        this.utilisateurRepository=utilisateurRepository;
    }

    @Override
    public String create(FactureDto dto) {
        mapper.convertFactEntitytoDto(repository.save(mapper.convertFactDtotoEntity(dto)));
        return "La facture a été ajouté avec succès";
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

    @Override
    public List<FactureDto> findByUtilisateur(String nom) {
        UtilisateurDto user= mapper.convertUserEntitytoDto(utilisateurRepository.findByNom(nom));
        return mapper.convertFactEntitiestoDtos(repository.findByUtilisateur(mapper.convertUserDtotoEntity(user)));
    }
}
