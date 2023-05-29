package ma.cigma.mypef.controllers;

import ma.cigma.mypef.dtos.SortieDto;
import ma.cigma.mypef.dtos.SortieKeyDto;
import ma.cigma.mypef.dtos.UtilisateurDto;
import ma.cigma.mypef.services.SortieService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sorties")
public class SortieController {
    private SortieService service;

    public SortieController(@Qualifier("sortie_service") SortieService service) {
        this.service = service;
    }
    //ajouter
    @PostMapping("/create")
    public Long create(@RequestBody SortieDto dto){
        return  service.create(dto);
    }
    //moudifier
    @PutMapping("/update")
    public Long update(@RequestBody SortieDto dto){
        return service.update(dto);
    }
    //supprimer
    @DeleteMapping("/{med}/{fact}")
    public boolean delete(@PathVariable("med") long med, @PathVariable("fact") long fact){
        SortieKeyDto keyDto=new SortieKeyDto(med, fact);
        return service.delete(keyDto);
    }
    //affichier tous
    @GetMapping("/read")
    public List<SortieDto> readAll(){
        return service.readAll();
    }
    //afficher par facture
    @GetMapping("/findbyFact")
    public List<SortieDto> readbyFact(@RequestParam("factureCode") long factureCode){
        return service.findByFacture(factureCode);
    }
    //afficher par medicament
    @GetMapping("/findbyMedicament")
    public List<SortieDto> readbyMedicament(@RequestParam("medicamentId") long medicamentId){
        return service.findByMedicament(medicamentId);
    }
}
