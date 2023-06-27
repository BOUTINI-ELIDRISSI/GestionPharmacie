package ma.cigma.mypef.services;

import ma.cigma.mypef.dtos.FournisseurDto;

import java.util.List;

public interface FournisseurService {
    String create(FournisseurDto dto);
    String update(FournisseurDto dto);
    String delete(long id);
    List<FournisseurDto> readAll();
    String findByNom(String nom);
}
