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

    //ajouter fournisseur
    @Override
    public String create(FournisseurDto dto) {
        FournisseurDto fournisseur = mapper.convertFournisseurEntitytoDto(repository.findByNom(dto.getNom()));
        if (fournisseur == null){
            mapper.convertFournisseurEntitytoDto(repository.save(mapper.convertFournisseurDtotoEntity(dto)));
            return "";
        }
        else
            return "";
    }
    //modifier fournisseur
    @Override
    public String update(FournisseurDto dto) {
        FournisseurDto fournisseur = mapper.convertFournisseurEntitytoDto(repository.findByNom(dto.getNom()));
        if (fournisseur != null){
            dto.setId(fournisseur.getId());
            mapper.convertFournisseurEntitytoDto(repository.save(mapper.convertFournisseurDtotoEntity(dto)));
            return "";
        }
        else
            return "";
    }
    //supprimer fournisseur
    @Override
    public String delete(long id) {
       repository.deleteById(id);
        return "";


    }
    //afficher list des fournisseurs
    @Override
    public List<FournisseurDto> readAll() {
        return mapper.convertFournisseurEntitiestoDtos(repository.findAll());
    }
    //afficher fournisseur by nom
    @Override
    public String findByNom(String nom) {
        FournisseurDto dto=mapper.convertFournisseurEntitytoDto(repository.findByNom(nom));
        if (dto != null)
            return dto.toString();
        else
            return "";
    }
}
