package ma.cigma.mypef.repositories;

import ma.cigma.mypef.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ligne_repo")
public interface LigneRepository extends JpaRepository<LigneEntity, LigneKeyEntity> {
    List<LigneEntity> findByCommande(CommandeEntity commande);
    List<LigneEntity> findByMedicament(MedicamentEntity medicament);
}
