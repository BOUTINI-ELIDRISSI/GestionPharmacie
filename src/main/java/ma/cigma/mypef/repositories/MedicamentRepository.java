package ma.cigma.mypef.repositories;

import ma.cigma.mypef.entities.ClientEntity;
import ma.cigma.mypef.entities.MedicamentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("medicament_repo")
public interface MedicamentRepository extends JpaRepository<MedicamentEntity, Long> {
}
