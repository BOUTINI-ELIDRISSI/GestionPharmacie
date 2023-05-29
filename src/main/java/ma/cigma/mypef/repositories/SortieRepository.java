package ma.cigma.mypef.repositories;

import ma.cigma.mypef.dtos.FactureDto;
import ma.cigma.mypef.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("sortie_repo")
public interface SortieRepository extends JpaRepository<SortieEntity, SortieKeyEntity> {
    List<SortieEntity> findByFacture(FactureEntity facture);
    List<SortieEntity> findByMedicament(MedicamentEntity medicament);
}
