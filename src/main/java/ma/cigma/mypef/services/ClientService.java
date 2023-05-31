package ma.cigma.mypef.services;

import ma.cigma.mypef.dtos.ClientDto;

import java.util.List;

public interface ClientService {
    String create(ClientDto dto);
    String update(ClientDto dto);
    String delete(long id);
    List<ClientDto> readAll();
    ClientDto findByNom(String nom);

}
