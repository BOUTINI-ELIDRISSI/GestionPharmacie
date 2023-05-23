package ma.cigma.mypef.repositories;

import ma.cigma.mypef.entities.ClientEntity;
import ma.cigma.mypef.entities.CommandeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("cmd_repo")
public interface CommandeRepository  extends JpaRepository<CommandeEntity, Long> {
}
