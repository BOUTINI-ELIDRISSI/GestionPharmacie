package ma.cigma.mypef.services;

import ma.cigma.mypef.dtos.CommandeDto;
import ma.cigma.mypef.mapper.Mapper_class;
import ma.cigma.mypef.repositories.CommandeRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cmd_service")
public class CommandeServiceImpl implements CommandeService{
    public CommandeRepository commandeRepository;
    public Mapper_class mapper =Mappers.getMapper(Mapper_class.class);

    public CommandeServiceImpl(@Qualifier("cmd_repo") CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    @Override
    public Long create(CommandeDto dto) {
        return mapper.convertCmdEntitytoDto(commandeRepository.save(mapper.convertCmdDtotoEntity(dto))).getCode();
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
}
