package ma.cigma.mypef.controllers;

import ma.cigma.mypef.dtos.ClientDto;
import ma.cigma.mypef.dtos.RoleDto;
import ma.cigma.mypef.services.RoleService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    private RoleService service;

    public RoleController(@Qualifier("role_service") RoleService service) {
        this.service = service;
    }
    @PostMapping("/create")
    public Long create(@RequestBody RoleDto dto){
        return  service.create(dto);
    }
    @PutMapping("/update")
    public Long update(@RequestBody RoleDto dto){
        return service.update(dto);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") long id){

        return service.delete(id);
    }
    @GetMapping("/read")
    public List<RoleDto> readAll(){
        return service.readAll();
    }
}
