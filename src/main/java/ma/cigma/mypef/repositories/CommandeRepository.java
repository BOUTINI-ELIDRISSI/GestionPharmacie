package ma.cigma.mypef.repositories;

import ma.cigma.mypef.entities.ClientEntity;
import ma.cigma.mypef.entities.CommandeEntity;
import ma.cigma.mypef.entities.UtilisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("cmd_repo")
public interface CommandeRepository  extends JpaRepository<CommandeEntity, Long> {
    List<CommandeEntity> findByUtilisateur(UtilisateurEntity utilisateur);
    List<CommandeEntity> findByClient(ClientEntity client);
    CommandeEntity findByCode(long code);

}
