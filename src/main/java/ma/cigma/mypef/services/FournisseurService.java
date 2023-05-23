package ma.cigma.mypef.services;

import ma.cigma.mypef.dtos.FournisseurDto;

import java.util.List;

public interface FournisseurService {
    Long create(FournisseurDto dto);
    Long update(FournisseurDto dto);
    boolean delete(long id);
    List<FournisseurDto> readAll();
}
