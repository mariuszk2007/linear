package eurogeo.pl.linear.linearservice.web.mapper;

import eurogeo.pl.linear.linearservice.domain.ERole;
import eurogeo.pl.linear.linearservice.domain.Role;
import eurogeo.pl.linear.model.RoleDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = RoleMapperImpl_.class)
class RoleMapperTest {

    @Autowired
    RoleMapper roleMapper;
    @Test
    void roleDtoToRole() {
        RoleDto roleDto = new RoleDto();
        roleDto.setId(1);
        roleDto.setRolename("user");
        Role role = roleMapper.roleDtoToRole(roleDto);
        ERole rolename =  role.getRolename();
        assertThat(rolename).isEqualByComparingTo(ERole.ROLE_USER);
    }
    @Test
    void roleDtoToRoleCheckSet() {
        RoleDto roleDto = new RoleDto();
        roleDto.setId(1);
        roleDto.setRolename("user");
        Role role = roleMapper.roleDtoToRole(roleDto);
        ERole rolename =  role.getRolename();
        assertThat(rolename).isEqualByComparingTo(ERole.ROLE_USER);
    }

    @Test
    void roleToRoleDto() {
       Role role = new Role();
       role.setRolename(ERole.ROLE_ADMIN);
       RoleDto roleDto = roleMapper.roleToRoleDto(role);
       assertThat(roleDto.getRolename()).isEqualTo("admin");
    }
}