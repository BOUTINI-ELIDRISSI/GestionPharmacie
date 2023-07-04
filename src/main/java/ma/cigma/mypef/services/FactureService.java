package ma.cigma.mypef.services;

import ma.cigma.mypef.dtos.ClientDto;
import ma.cigma.mypef.dtos.FactureDto;

import java.util.Date;
import java.util.List;

public interface FactureService {
    String create(FactureDto dto);
    Long update(FactureDto dto);
    boolean delete(long id);
    List<FactureDto> readAll();
     long findByBigCode();
    List<FactureDto> findByUtilisateur(String nom);
     FactureDto findByCode(long code);
}
