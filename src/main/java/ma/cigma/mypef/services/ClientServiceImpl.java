package ma.cigma.mypef.services;

import ma.cigma.mypef.dtos.ClientDto;
import ma.cigma.mypef.mapper.Mapper_class;
import ma.cigma.mypef.repositories.ClientRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("client_service")
public class ClientServiceImpl implements ClientService{

    public ClientRepository clientRepository;
    public Mapper_class mapper= Mappers.getMapper(Mapper_class.class);

    public ClientServiceImpl(@Qualifier("client_repo") ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Long create(ClientDto dto) {
        return mapper.convertClientEntitytoDto(clientRepository.save(mapper.convertClientDtotoEntity(dto))).getId();
    }

    @Override
    public Long update(ClientDto dto) {
        return mapper.convertClientEntitytoDto(clientRepository.save(mapper.convertClientDtotoEntity(dto))).getId();
    }

    @Override
    public boolean delete(long id) {
        clientRepository.deleteById(id);
        return true;
    }

    @Override
    public List<ClientDto> readAll() {
        return mapper.convertClientEntitiestoDtos(clientRepository.findAll());
    }
}
