package ma.cigma.mypef.repositories;

import ma.cigma.mypef.entities.ClientEntity;
import ma.cigma.mypef.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("role_repo")
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findByNom(String roleNom);
}
