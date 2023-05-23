package ma.cigma.mypef.services;

import ma.cigma.mypef.dtos.ClientDto;
import ma.cigma.mypef.dtos.SortieDto;
import ma.cigma.mypef.dtos.SortieKeyDto;

import java.util.List;

public interface SortieService {
    Long create(SortieDto dto);
    Long update(SortieDto dto);
    boolean delete(SortieKeyDto key);
    List<SortieDto> readAll();
}
