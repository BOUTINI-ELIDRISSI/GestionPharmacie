package ma.cigma.mypef.controllers;

import ma.cigma.mypef.dtos.ClientDto;
import ma.cigma.mypef.dtos.RoleDto;
import ma.cigma.mypef.dtos.UtilisateurDto;
import ma.cigma.mypef.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UtilisateurController {
    private UtilisateurService service;

    public UtilisateurController(@Qualifier("user_service") UtilisateurService service) {
        this.service = service;
    }
    @PostMapping("/create")
    public Long create(@RequestBody UtilisateurDto dto){
        return  service.create(dto);
    }
    @PutMapping("/update")
    public Long update(@RequestBody UtilisateurDto dto){
        return service.update(dto);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") long id){

        return service.delete(id);
    }
    @GetMapping("/read")
    public List<UtilisateurDto> readAll(){
        return service.readAll();
    }

    @GetMapping("/findbyRole")
    public List<UtilisateurDto> readbyRole(@RequestParam("roleName") String roleNom){
        return service.findbyRole(roleNom);
    }

    @GetMapping("/findbyNom")
    public UtilisateurDto readbyNom(@RequestParam("nom") String nom){
        return service.findByNom(nom);
    }
}
