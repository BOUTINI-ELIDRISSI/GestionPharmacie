package ma.cigma.mypef.services;

import ma.cigma.mypef.dtos.FactureDto;
import ma.cigma.mypef.dtos.UtilisateurDto;
import ma.cigma.mypef.entities.FactureEntity;
import ma.cigma.mypef.mapper.Mapper_class;
import ma.cigma.mypef.repositories.FactureRepository;
import ma.cigma.mypef.repositories.UtilisateurRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

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

    @Override
    public FactureDto findByCode(long code) {
        Optional<FactureEntity> optionalFacture = repository.findById(code);
        if (optionalFacture.isPresent()) {
            FactureEntity factureEntity = optionalFacture.get();
            return mapper.convertFactEntitytoDto(factureEntity);
        } else {
            // Handle the case when the FactureEntity is not found
            return null; // or throw an exception, or return an appropriate response
        }

    }

    @Override
    public long findByBigCode() {
        List<FactureDto> dtos = mapper.convertFactEntitiestoDtos(repository.findAll());
        long id =0;
        for (int i = 0; i < dtos.size(); i++) {
            if(id < dtos.get(i).getCode())
                id = dtos.get(i).getCode();
        }
        return id;
    }
}
