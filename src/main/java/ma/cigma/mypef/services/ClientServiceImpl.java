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
    public String create(ClientDto dto) {
        ClientDto client = mapper.convertClientEntitytoDto(clientRepository.findByNom(dto.getNom()));
        if(client == null){
            mapper.convertClientEntitytoDto(clientRepository.save(mapper.convertClientDtotoEntity(dto)));
            return "";
        }
        else
            return "";
    }

    @Override
    public String update(ClientDto dto) {
        ClientDto client = mapper.convertClientEntitytoDto(clientRepository.findByNom(dto.getNom()));
        if(client != null){
            dto.setId(client.getId());
            mapper.convertClientEntitytoDto(clientRepository.save(mapper.convertClientDtotoEntity(dto)));
            return "";
        }
        else
            return "";
    }

    @Override
    public String delete(long id) {
        clientRepository.deleteById(id);
        return "";
    }

    @Override
    public List<ClientDto> readAll() {
        return mapper.convertClientEntitiestoDtos(clientRepository.findAll());
    }

    @Override
    public ClientDto findByNom(String nom) {
        return mapper.convertClientEntitytoDto(clientRepository.findByNom(nom));
    }

    @Override
    public ClientDto findByEmail(String email) {
        return mapper.convertClientEntitytoDto(clientRepository.findByEmail(email));
    }

}
