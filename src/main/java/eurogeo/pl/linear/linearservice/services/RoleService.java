package eurogeo.pl.linear.linearservice.services;

import eurogeo.pl.linear.model.RoleDto;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {
    RoleDto save(RoleDto roleName);
    RoleDto findByRolename(String name);
    boolean existByRolename(String role);
}
