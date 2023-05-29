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
    //supprimer medicament by libelle
    String delete(String libelle);
    //afficher list des medicament
    List<MedicamentDto> readAll();
    //afficher par libelle

    String findByLibelle(String libelle);
}
