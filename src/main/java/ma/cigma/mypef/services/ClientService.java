package ma.cigma.mypef.services;

import ma.cigma.mypef.dtos.ClientDto;

import java.util.List;

public interface ClientService {
    Long create(ClientDto dto);
    Long update(ClientDto dto);
    boolean delete(long id);
    List<ClientDto> readAll();

}
