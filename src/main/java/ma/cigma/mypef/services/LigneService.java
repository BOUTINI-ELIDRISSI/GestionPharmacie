package ma.cigma.mypef.services;

import ma.cigma.mypef.dtos.ClientDto;
import ma.cigma.mypef.dtos.LigneDto;
import ma.cigma.mypef.dtos.LigneKeyDto;

import java.util.List;

public interface LigneService {
    Long create(LigneDto dto);
    Long update(LigneDto dto);
    boolean delete(LigneKeyDto key);
    List<LigneDto> readAll();
}
