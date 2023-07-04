package ma.cigma.mypef.controllers;

import ma.cigma.mypef.dtos.ClientDto;
import ma.cigma.mypef.dtos.EntreeDto;
import ma.cigma.mypef.services.EntreeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entree")
public class EntreeController {
    private EntreeService service;

    public EntreeController(@Qualifier("entree_service") EntreeService service) {
        this.service = service;
    }
    @PostMapping("/create")
    public Long create(@RequestBody EntreeDto dto){
        return  service.create(dto);
    }
    @PutMapping("/update")
    public Long update(@RequestBody EntreeDto dto){
        return service.update(dto);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") long id){

        return service.delete(id);
    }
    @GetMapping("/read")
    public List<EntreeDto> readAll(){
        return service.readAll();
    }

    @GetMapping("/findByMedicament")
    public List<EntreeDto> findByMedicament(@RequestParam("libelle") String libelle){
        return service.findByMedicament(libelle);
    }
    @GetMapping("/findByFournisseur")
    public List<EntreeDto> findByFournisseur(@RequestParam("nom") String nom){
        return service.findByFournisseur(nom);
    }
    @GetMapping("/findByUtilisateur")
    public List<EntreeDto> findByUtilisateur(@RequestParam("nom") String nom){
        return service.findByUtilisateur(nom);
    }
    @GetMapping("/findByLastEntree")
    public EntreeDto findByLastEntree(@RequestParam("libelle") String libelle){
        return service.findByLastEntree(libelle);
    }
}
