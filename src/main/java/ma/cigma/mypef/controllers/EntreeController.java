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
}
