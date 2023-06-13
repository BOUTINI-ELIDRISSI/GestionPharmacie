package ma.cigma.mypef.controllers;

import ma.cigma.mypef.dtos.ClientDto;
import ma.cigma.mypef.dtos.LigneDto;
import ma.cigma.mypef.dtos.LigneKeyDto;
import ma.cigma.mypef.dtos.SortieDto;
import ma.cigma.mypef.services.LigneService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lignes")
public class LigneController {
    private LigneService service;

    public LigneController(@Qualifier("ligne_service") LigneService service) {
        this.service = service;
    }
    @PostMapping("/create")
    public String create(@RequestBody LigneDto dto){
        return  service.create(dto);
    }
    @PutMapping("/update")
    public String update(@RequestBody LigneDto dto){
        return service.update(dto);
    }
    @DeleteMapping("/{med}/{cmd}")
    public boolean delete(@PathVariable("med") String med, @PathVariable("cmd") long cmd){
        return service.delete(med,cmd);
    }
    @GetMapping("/read")
    public List<LigneDto> readAll(){
        return service.readAll();
    }

    //afficher par facture
    @GetMapping("/findbyCommand")
    public List<LigneDto> findByCommand(@RequestParam("commandCode") long commandeCode){
        return service.findByCommand(commandeCode);
    }
    //afficher par medicament
    @GetMapping("/findbyMedicament")
    public List<LigneDto> findByMedicament(@RequestParam("medicamentLibelle") String libelle){
        return service.findByMedicament(libelle);
    }
}
