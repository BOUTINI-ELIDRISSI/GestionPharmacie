package ma.cigma.mypef.repositories;

import ma.cigma.mypef.entities.FournisseurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("fournisseur_repo")
public interface FournisseurRepository extends JpaRepository<FournisseurEntity, Long> {

    FournisseurEntity findByNom(String nom);
}
