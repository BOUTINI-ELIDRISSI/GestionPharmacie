package ma.cigma.mypef.controllers;

import ma.cigma.mypef.dtos.ClientDto;
import ma.cigma.mypef.dtos.MedicamentDto;
import ma.cigma.mypef.services.MedicamentService;
import org.springframework.beans.factory.annotation.Qualifier;
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
    public Long create(@RequestBody MedicamentDto dto){
        return  service.create(dto);
    }
    @PutMapping("/update")
    public Long update(@RequestBody MedicamentDto dto){
        return service.update(dto);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") long id){

        return service.delete(id);
    }
    @GetMapping("/read")
    public List<MedicamentDto> readAll(){
        return service.readAll();
    }
}
