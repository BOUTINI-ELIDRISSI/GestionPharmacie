package ma.cigma.mypef.controllers;

import ma.cigma.mypef.dtos.ClientDto;
import ma.cigma.mypef.dtos.FournisseurDto;
import ma.cigma.mypef.services.FournisseurService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fournisseurs")
public class FournisseurController {
    private FournisseurService service;

    public FournisseurController(@Qualifier("fournisseur_service") FournisseurService service) {
        this.service = service;
    }
    @PostMapping("/create")
    public String create(@RequestBody FournisseurDto dto){
        return  service.create(dto);
    }
    @PutMapping("/update")
    public String update(@RequestBody FournisseurDto dto){
        return service.update(dto);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id){

        return service.delete(id);
    }
    @GetMapping("/read")
    public List<FournisseurDto> readAll(){
        return service.readAll();
    }
    @GetMapping("/findByNom")
    public String findByNom(@RequestParam("nom") String nom){
        return service.findByNom(nom);
    }
}
