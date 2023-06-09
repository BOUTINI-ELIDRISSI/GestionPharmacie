package ma.cigma.mypef.services;

import ma.cigma.mypef.dtos.*;
import ma.cigma.mypef.mapper.Mapper_class;
import ma.cigma.mypef.repositories.EntreeRepository;
import ma.cigma.mypef.repositories.FournisseurRepository;
import ma.cigma.mypef.repositories.MedicamentRepository;
import ma.cigma.mypef.repositories.UtilisateurRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("entree_service")
public class EntreeServiceImpl implements EntreeService{
    public EntreeRepository entreeRepository;
    public FournisseurRepository fournisseurRepository;
    public UtilisateurRepository utilisateurRepository;
    public MedicamentRepository medicamentRepository;
    public Mapper_class mapper= Mappers.getMapper(Mapper_class.class);

    public EntreeServiceImpl(@Qualifier("entree_repo") EntreeRepository entreeRepository, @Qualifier("medicament_repo")MedicamentRepository medicamentRepository
            ,@Qualifier("fournisseur_repo") FournisseurRepository fournisseurRepository, @Qualifier("user_repo") UtilisateurRepository utilisateurRepository) {
        this.entreeRepository = entreeRepository;
        this.medicamentRepository=medicamentRepository;
        this.fournisseurRepository=fournisseurRepository;
        this.utilisateurRepository=utilisateurRepository;
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

    @Override
    public List<EntreeDto> findByMedicament(String libelle) {
        MedicamentDto medicament = mapper.convertMedicamentEntitytoDto(medicamentRepository.findByLibelle(libelle));
        return mapper.convertEntreeEntitiestoDtos(entreeRepository.findByMedicament(mapper.convertMedicamentDtotoEntity(medicament)));
    }

    @Override
    public List<EntreeDto> findByFournisseur(String nom) {
        FournisseurDto fournisseur = mapper.convertFournisseurEntitytoDto(fournisseurRepository.findByNom(nom));
        return mapper.convertEntreeEntitiestoDtos(entreeRepository.findByFournisseur(mapper.convertFournisseurDtotoEntity(fournisseur)));
    }

    @Override
    public List<EntreeDto> findByUtilisateur(String nom) {
        UtilisateurDto utilisateur = mapper.convertUserEntitytoDto(utilisateurRepository.findByNom(nom));
        return mapper.convertEntreeEntitiestoDtos(entreeRepository.findByUtilisateur(mapper.convertUserDtotoEntity(utilisateur)));
    }

    @Override
    public EntreeDto findByLastEntree(String libelle) {
        List<EntreeDto> entree = findByMedicament(libelle);


            Date max = null;
            long id = 0;
            for (int i = 0; i < entree.size(); i++) {
                if (max == null) {
                        max = entree.get(i).getDate_entree();
                        id = entree.get(i).getId();
                    } else {
                        if (max.compareTo(entree.get(i).getDate_entree()) < 0) {
                            max = entree.get(i).getDate_entree();
                            id = entree.get(i).getId();
                        }
                    }


            }
            return mapper.convertEntreeEntitytoDto(entreeRepository.findById(id));

    }


}
