package ma.cigma.mypef.repositories;

import ma.cigma.mypef.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("entree_repo")
public interface EntreeRepository extends JpaRepository<EntreeEntity, Long> {
    List<EntreeEntity> findByMedicament(MedicamentEntity medicament);
    List<EntreeEntity> findByFournisseur(FournisseurEntity fournisseur);
    List<EntreeEntity> findByUtilisateur(UtilisateurEntity utilisateur);

}
