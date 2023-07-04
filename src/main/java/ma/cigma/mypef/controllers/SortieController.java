package ma.cigma.mypef.controllers;

import ma.cigma.mypef.dtos.SortieDto;
import ma.cigma.mypef.dtos.SortieKeyDto;
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
    public String create(@RequestBody SortieDto dto){
        return  service.create(dto);
    }
    @PostMapping("/create_table")
    public String create_table(@RequestBody List<SortieDto> dtos){
        return  service.create_table(dtos);
    }
    //moudifier
    @PutMapping("/update")
    public String update(@RequestBody SortieDto dto){
        return service.update(dto);
    }
    //supprimer
    @DeleteMapping("{fact}")
    public boolean delete( @PathVariable("fact") long fact){
        return service.delete(fact);
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
    public List<SortieDto> readbyMedicament(@RequestParam("medicamentLibelle") String libelle){
        return service.findByMedicament(libelle);
    }
}
