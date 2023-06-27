package ma.cigma.mypef.repositories;

import ma.cigma.mypef.dtos.UtilisateurDto;
import ma.cigma.mypef.entities.ClientEntity;
import ma.cigma.mypef.entities.RoleEntity;
import ma.cigma.mypef.entities.UtilisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("user_repo")
public interface UtilisateurRepository extends JpaRepository<UtilisateurEntity, Long> {
    List<UtilisateurEntity> findByRole (RoleEntity role);
    UtilisateurEntity findByNom (String nom);
    UtilisateurEntity findByEmail (String email);
}
