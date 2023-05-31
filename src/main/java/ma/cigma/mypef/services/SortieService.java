package ma.cigma.mypef.services;

import ma.cigma.mypef.dtos.ClientDto;
import ma.cigma.mypef.dtos.FactureDto;
import ma.cigma.mypef.dtos.SortieDto;
import ma.cigma.mypef.dtos.SortieKeyDto;

import java.util.List;

public interface SortieService {
    String create(SortieDto dto);
    String update(SortieDto dto);
    boolean delete(String libelle, long code);
    List<SortieDto> readAll();
    List<SortieDto> findByFacture(long factureCode);
    List<SortieDto> findByMedicament(String libelle);
}
