package ma.cigma.mypef.repositories;

import ma.cigma.mypef.entities.ClientEntity;
import ma.cigma.mypef.entities.UtilisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("user_repo")
public interface UtilisateurRepository extends JpaRepository<UtilisateurEntity, Long> {
}
