package ma.cigma.mypef.controllers;

import ma.cigma.mypef.dtos.CommandeDto;
import ma.cigma.mypef.services.CommandeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cmd")
public class CommandeController {
    private CommandeService service;

    public CommandeController(@Qualifier("cmd_service") CommandeService service) {
        this.service = service;
    }
    @PostMapping("/create")
    public String  create(@RequestBody CommandeDto dto){
        return  service.create(dto);
    }
    @PutMapping("/update")
    public Long update(@RequestBody CommandeDto dto){
        return service.update(dto);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") long id){

        return service.delete(id);
    }
    @GetMapping("/read")
    public List<CommandeDto> readAll(){
        return service.readAll();
    }
    @GetMapping("/findByUtilisateur")
    public List<CommandeDto> findByUtilisateur(@RequestParam("nom")String nom){
        return service.findByUtilisateur(nom);
    }
    @GetMapping("/findByClient")
    public List<CommandeDto> findByClient(@RequestParam("nom")String nom){
        return service.findByClient(nom);
    }
    @GetMapping("/findByBigcode")
    public long findByBigcode() {
        return service.findByBigCode();
    }
    @GetMapping("/findNoUser")
    public List<CommandeDto>  findByNoUser(){
        return service.findByNoUser();
    }
    @GetMapping("/findWithUser")
    public List<CommandeDto>  findByWithUser(){
        return service.findByWithUser();
    }
    @GetMapping("/findByCode")
    CommandeDto findByCode(@RequestParam("code")long code){
        return service.findByCode(code);
    }
}

