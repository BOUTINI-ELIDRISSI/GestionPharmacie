package ma.cigma.mypef.services;

import ma.cigma.mypef.dtos.ClientDto;
import ma.cigma.mypef.dtos.MedicamentDto;

import java.util.List;

public interface MedicamentService {
    Long create(MedicamentDto dto);
    Long update(MedicamentDto dto);
    boolean delete(long id);
    List<MedicamentDto> readAll();
}
