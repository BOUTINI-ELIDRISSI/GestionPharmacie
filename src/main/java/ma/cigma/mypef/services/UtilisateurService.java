package ma.cigma.mypef.services;

import ma.cigma.mypef.dtos.ClientDto;
import ma.cigma.mypef.dtos.RoleDto;
import ma.cigma.mypef.dtos.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {
    Long create(UtilisateurDto dto);
    Long update(UtilisateurDto dto);
    boolean delete(long id);
    List<UtilisateurDto> readAll();
    List<UtilisateurDto> findbyRole(String roleNom);
    UtilisateurDto findByNom(String Nom);
}
