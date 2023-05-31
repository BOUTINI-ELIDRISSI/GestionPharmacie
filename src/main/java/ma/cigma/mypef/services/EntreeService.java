package ma.cigma.mypef.services;

import ma.cigma.mypef.dtos.ClientDto;
import ma.cigma.mypef.dtos.EntreeDto;

import java.util.List;

public interface EntreeService {
    Long create(EntreeDto dto);
    Long update(EntreeDto dto);
    boolean delete(long id);
    List<EntreeDto> readAll();
    List<EntreeDto> findByMedicament(String libelle);
}
