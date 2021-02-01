package eurogeo.pl.linear.linearservice.web.mapper;

import eurogeo.pl.linear.linearservice.domain.Role;
import eurogeo.pl.linear.model.RoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class RoleMapperDecorator implements RoleMapper{
    private RoleMapper mapper;
    @Autowired
    public void setRoleMapper(RoleMapper mapper){
        this.mapper = mapper;
    }
    @Override
    public Role roleDtoToRole(RoleDto roleDto) {
        return mapper.roleDtoToRole(roleDto);
    }

    @Override
    public RoleDto roleToRoleDto(Role role) {
        return mapper.roleToRoleDto(role);
    }
}
