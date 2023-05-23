package ma.cigma.mypef.controllers;

import ma.cigma.mypef.dtos.ClientDto;
import ma.cigma.mypef.dtos.LigneDto;
import ma.cigma.mypef.dtos.LigneKeyDto;
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
    public Long create(@RequestBody LigneDto dto){
        return  service.create(dto);
    }
    @PutMapping("/update")
    public Long update(@RequestBody LigneDto dto){
        return service.update(dto);
    }
    @DeleteMapping("/{med}/{cmd}")
    public boolean delete(@PathVariable("med") long med, @PathVariable("cmd") long cmd){
        LigneKeyDto keyDto=new LigneKeyDto(med,cmd);
        return service.delete(keyDto);
    }
    @GetMapping("/read")
    public List<LigneDto> readAll(){
        return service.readAll();
    }
}
