package ma.cigma.mypef.services;

import ma.cigma.mypef.dtos.ClientDto;
import ma.cigma.mypef.dtos.RoleDto;
import ma.cigma.mypef.dtos.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {
    String create(UtilisateurDto dto);
    String update(UtilisateurDto dto);
    String delete(long id);
    List<UtilisateurDto> readAll();
    List<UtilisateurDto> findbyRole(String roleNom);
    UtilisateurDto findByNom(String Nom);
}
