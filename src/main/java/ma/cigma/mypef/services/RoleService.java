package ma.cigma.mypef.services;

import ma.cigma.mypef.dtos.ClientDto;
import ma.cigma.mypef.dtos.RoleDto;

import java.util.List;

public interface RoleService {
    Long create(RoleDto dto);
    Long update(RoleDto dto);
    boolean delete(long id);
    List<RoleDto> readAll();
}
