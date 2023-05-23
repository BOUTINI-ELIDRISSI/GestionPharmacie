package ma.cigma.mypef.repositories;

import ma.cigma.mypef.entities.ClientEntity;
import ma.cigma.mypef.entities.LigneEntity;
import ma.cigma.mypef.entities.LigneKeyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ligne_repo")
public interface LigneRepository extends JpaRepository<LigneEntity, LigneKeyEntity> {
}
