package ma.cigma.mypef.repositories;

import ma.cigma.mypef.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("client_repo")
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
}
