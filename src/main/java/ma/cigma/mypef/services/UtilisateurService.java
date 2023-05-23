package ma.cigma.mypef.services;

import ma.cigma.mypef.dtos.ClientDto;
import ma.cigma.mypef.dtos.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {
    Long create(UtilisateurDto dto);
    Long update(UtilisateurDto dto);
    boolean delete(long id);
    List<UtilisateurDto> readAll();
}
