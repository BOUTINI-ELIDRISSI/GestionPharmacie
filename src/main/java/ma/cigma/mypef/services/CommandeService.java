package ma.cigma.mypef.services;

import ma.cigma.mypef.dtos.CommandeDto;
import ma.cigma.mypef.entities.CommandeEntity;

import java.util.List;

public interface CommandeService {
    String create(CommandeDto dto);
    Long update(CommandeDto dto);
    boolean delete(long id);
    List<CommandeDto> readAll();
    List<CommandeDto> findByUtilisateur(String nom);
    List<CommandeDto> findByClient(String nom);
    long findByBigCode();
     List<CommandeDto>  findByNoUser();
    List<CommandeDto>  findByWithUser();

    CommandeDto findByCode(long code);

}
