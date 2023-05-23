package ma.cigma.mypef.repositories;

import ma.cigma.mypef.entities.ClientEntity;
import ma.cigma.mypef.entities.SortieEntity;
import ma.cigma.mypef.entities.SortieKeyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("sortie_repo")
public interface SortieRepository extends JpaRepository<SortieEntity, SortieKeyEntity> {
}
