package eurogeo.pl.linear.linearservice.web.mapper;

import eurogeo.pl.linear.linearservice.domain.ERole;
import eurogeo.pl.linear.linearservice.domain.Role;
import eurogeo.pl.linear.model.RoleDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(componentModel = "spring", uses=RoleMapper.class)
public interface SetRoleMapper {

    Set<Role> setRoleDtoToRole(Set<RoleDto> rolesString);
    Set<RoleDto> setRoleToRoleDto (Set<Role> rolesRole);


}
