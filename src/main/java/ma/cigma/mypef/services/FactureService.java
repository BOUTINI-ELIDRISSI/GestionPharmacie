package ma.cigma.mypef.services;

import ma.cigma.mypef.dtos.ClientDto;
import ma.cigma.mypef.dtos.FactureDto;

import java.util.List;

public interface FactureService {
    String create(FactureDto dto);
    Long update(FactureDto dto);
    boolean delete(long id);
    List<FactureDto> readAll();
    List<FactureDto> findByUtilisateur(String nom);
}
