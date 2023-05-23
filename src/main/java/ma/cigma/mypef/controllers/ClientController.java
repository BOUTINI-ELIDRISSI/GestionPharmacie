package ma.cigma.mypef.controllers;

import ma.cigma.mypef.dtos.ClientDto;
import ma.cigma.mypef.services.ClientService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private ClientService service;

    public ClientController(@Qualifier("client_service") ClientService service) {
        this.service = service;
    }
    @PostMapping("/create")
    public Long create(@RequestBody ClientDto dto){
        return  service.create(dto);
    }
    @PutMapping("/update")
    public Long update(@RequestBody ClientDto dto){
        return service.update(dto);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") long id){

        return service.delete(id);
    }
    @GetMapping("/read")
    public List<ClientDto> readAll(){
        return service.readAll();
    }
}
