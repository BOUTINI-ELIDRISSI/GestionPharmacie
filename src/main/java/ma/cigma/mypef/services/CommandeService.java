package ma.cigma.mypef.services;

import ma.cigma.mypef.dtos.CommandeDto;

import java.util.List;

public interface CommandeService {
    Long create(CommandeDto dto);
    Long update(CommandeDto dto);
    boolean delete(long id);
    List<CommandeDto> readAll();
}
