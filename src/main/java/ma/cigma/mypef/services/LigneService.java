package ma.cigma.mypef.services;

import ma.cigma.mypef.dtos.ClientDto;
import ma.cigma.mypef.dtos.LigneDto;
import ma.cigma.mypef.dtos.LigneKeyDto;
import ma.cigma.mypef.dtos.SortieDto;

import java.util.List;

public interface LigneService {
    String create(LigneDto dto);
    String update(LigneDto dto);
    boolean delete(String libelle, long code);
    List<LigneDto> readAll();
    List<LigneDto> findByCommand(long cmdCode);
    List<LigneDto> findByMedicament(String libelle);
}
