package ma.cigma.mypef.repositories;

import ma.cigma.mypef.entities.ClientEntity;
import ma.cigma.mypef.entities.FactureEntity;
import ma.cigma.mypef.entities.UtilisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository("fact_repo")
public interface FactureRepository extends JpaRepository<FactureEntity, Long> {
    List<FactureEntity> findByUtilisateur(UtilisateurEntity utilisateur);

    FactureEntity findByCode(long code);

}
