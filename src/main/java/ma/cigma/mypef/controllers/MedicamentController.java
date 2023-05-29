package ma.cigma.mypef.controllers;

import ma.cigma.mypef.dtos.ClientDto;
import ma.cigma.mypef.dtos.MedicamentDto;
import ma.cigma.mypef.services.MedicamentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicaments")
public class MedicamentController {
    private MedicamentService service;

    public MedicamentController(@Qualifier("medicament_service") MedicamentService service) {
        this.service = service;
    }
    @PostMapping("/create")
    public String create(@RequestBody MedicamentDto dto){
        return  service.create(dto);
    }
    @PutMapping("/update")
    public String update(@RequestBody MedicamentDto dto){
        return service.update(dto);
    }
    @DeleteMapping("/{libelle}")
    public String delete(@PathVariable("libelle") String libelle){

        return service.delete(libelle);
    }
    @GetMapping("/read")
    public List<MedicamentDto> readAll(){
        return service.readAll();
    }
    @GetMapping("/findbylibelle")
    public String findByLibelle(@RequestParam("libelle") String libelle){
        return service.findByLibelle(libelle);
    }
}
