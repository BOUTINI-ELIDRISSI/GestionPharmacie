package ma.cigma.mypef.controllers;

import ma.cigma.mypef.dtos.ClientDto;
import ma.cigma.mypef.dtos.FactureDto;
import ma.cigma.mypef.services.FactureService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facts")
public class FactureController {
    private FactureService service;

    public FactureController(@Qualifier("fact_service") FactureService service) {
        this.service = service;
    }
    @PostMapping("/create")
    public String create(@RequestBody FactureDto dto){
        return  service.create(dto);
    }
    @PutMapping("/update")
    public Long update(@RequestBody FactureDto dto){
        return service.update(dto);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") long id){

        return service.delete(id);
    }
    @GetMapping("/read")
    public List<FactureDto> readAll(){
        return service.readAll();
    }

    @GetMapping("/findByUtilisateur")
    public List<FactureDto> findByUtilisateur(@RequestParam("nom")String nom){
        return service.findByUtilisateur(nom);
    }
}
