package ma.cigma.mypef.repositories;

import ma.cigma.mypef.entities.ClientEntity;
import ma.cigma.mypef.entities.UtilisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("client_repo")
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    ClientEntity findByNom(String nom);
    ClientEntity findByEmail (String email);

}
