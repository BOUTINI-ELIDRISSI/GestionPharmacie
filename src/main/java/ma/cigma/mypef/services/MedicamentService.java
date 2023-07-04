package ma.cigma.mypef.services;

import ma.cigma.mypef.dtos.ClientDto;
import ma.cigma.mypef.dtos.MedicamentDto;
import ma.cigma.mypef.entities.MedicamentEntity;

import java.util.List;

public interface MedicamentService {
    //ajouter medicament
    String create(MedicamentDto dto);
    //modifier medicament
    String update(MedicamentDto dto);
    //supprimer medicament by id
    String delete(long id);
    //afficher list des medicament
    List<MedicamentDto> readAll();
    //afficher par libelle

    MedicamentDto findByLibelle(String libelle);
}
