package ma.cigma.mypef.services;

import ma.cigma.mypef.dtos.ClientDto;
import ma.cigma.mypef.dtos.CommandeDto;
import ma.cigma.mypef.dtos.UtilisateurDto;
import ma.cigma.mypef.mapper.Mapper_class;
import ma.cigma.mypef.repositories.ClientRepository;
import ma.cigma.mypef.repositories.CommandeRepository;
import ma.cigma.mypef.repositories.UtilisateurRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cmd_service")
public class CommandeServiceImpl implements CommandeService{
    public CommandeRepository commandeRepository;
    public UtilisateurRepository utilisateurRepository;
    public ClientRepository clientRepository;
    public Mapper_class mapper =Mappers.getMapper(Mapper_class.class);

    public CommandeServiceImpl(@Qualifier("cmd_repo") CommandeRepository commandeRepository
            ,@Qualifier("user_repo")UtilisateurRepository utilisateurRepository,@Qualifier("client_repo")ClientRepository clientRepository) {
        this.commandeRepository = commandeRepository;
        this.utilisateurRepository=utilisateurRepository;
        this.clientRepository=clientRepository;
    }
    @Override
    public String create(CommandeDto dto) {
         mapper.convertCmdEntitytoDto(commandeRepository.save(mapper.convertCmdDtotoEntity(dto)));
         return "ma commande a été enregistré avec succès";
    }
    @Override
    public Long update(CommandeDto dto) {
        return mapper.convertCmdEntitytoDto(commandeRepository.save(mapper.convertCmdDtotoEntity(dto))).getCode();
    }
    @Override
    public boolean delete(long id) {
        commandeRepository.deleteById(id);
        return true;
    }
    @Override
    public List<CommandeDto> readAll() {
        return mapper.convertCmdEntitiestoDtos(commandeRepository.findAll());
    }

    @Override
    public List<CommandeDto> findByUtilisateur(String nom) {
        UtilisateurDto user= mapper.convertUserEntitytoDto(utilisateurRepository.findByNom(nom));
        return mapper.convertCmdEntitiestoDtos(commandeRepository.findByUtilisateur(mapper.convertUserDtotoEntity(user)));
    }
    @Override
    public List<CommandeDto> findByClient(String nom) {
        ClientDto client= mapper.convertClientEntitytoDto(clientRepository.findByNom(nom));
        return mapper.convertCmdEntitiestoDtos(commandeRepository.findByClient(mapper.convertClientDtotoEntity(client)));
    }
}
