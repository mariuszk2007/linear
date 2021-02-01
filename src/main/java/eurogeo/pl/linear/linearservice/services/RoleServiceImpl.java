package eurogeo.pl.linear.linearservice.services;

import eurogeo.pl.linear.linearservice.domain.ERole;
import eurogeo.pl.linear.linearservice.domain.Role;
import eurogeo.pl.linear.linearservice.repositories.RoleRepository;
import eurogeo.pl.linear.linearservice.web.mapper.RoleMapper;
import eurogeo.pl.linear.model.RoleDto;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    RoleRepository roleRepository;

    @Override
    public RoleDto save(RoleDto roleDto) {
        if (existByRolename(roleDto.getRolename())) {
            return findByRolename(roleDto.getRolename());
        }
        else


            return roleMapper.roleToRoleDto(roleRepository.save(roleMapper.roleDtoToRole(roleDto)));
        }

    @Override
    public RoleDto findByRolename(String name) {
    RoleDto roleDto = new RoleDto();
    roleDto.setRolename(name);
    Role role = roleMapper.roleDtoToRole(roleDto);
        return roleMapper.roleToRoleDto(roleRepository.findByRolename(role.getRolename()));
    }

    @Override
    public boolean existByRolename(String name) {
        ERole nameEnum;
        switch (name){
            case "admin":
            {
                nameEnum = ERole.ROLE_ADMIN;
            }
            case "mod":
            {
                nameEnum = ERole.ROLE_MODERATOR;
            }
            default:
                nameEnum = ERole.ROLE_USER;
        }

        return roleRepository.existsByRolename(nameEnum);
    }
}
