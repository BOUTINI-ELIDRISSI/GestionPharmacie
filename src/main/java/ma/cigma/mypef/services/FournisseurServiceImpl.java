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
            return "Le fournisseur a été ajouté avec succès";
        }
        else
            return "Le fournisseur existe déjà";
    }
    //modifier fournisseur
    @Override
    public String update(FournisseurDto dto) {
        FournisseurDto fournisseur = mapper.convertFournisseurEntitytoDto(repository.findByNom(dto.getNom()));
        if (fournisseur != null){
            dto.setId(fournisseur.getId());
            mapper.convertFournisseurEntitytoDto(repository.save(mapper.convertFournisseurDtotoEntity(dto)));
            return "Le fournisseur a été modifié avec succès";
        }
        else
            return "Le fournisseur n'existe pas";
    }
    //supprimer fournisseur
    @Override
    public String delete(String nom) {
        FournisseurDto fournisseur = mapper.convertFournisseurEntitytoDto(repository.findByNom(nom));
        if (fournisseur != null){
            repository.deleteById(fournisseur.getId());
            return "Le fournisseur a été supprimé avec succès";
        }
        else
            return "Le fournisseur n'existe pas";

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
            return "le fournisseur n'existe pas";
    }
}
