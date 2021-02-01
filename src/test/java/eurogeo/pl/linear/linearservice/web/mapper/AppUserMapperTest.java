package eurogeo.pl.linear.linearservice.web.mapper;

import eurogeo.pl.linear.linearservice.domain.AppUser;
import eurogeo.pl.linear.linearservice.domain.ERole;
import eurogeo.pl.linear.linearservice.domain.Role;
import eurogeo.pl.linear.model.AppUserDto;
import eurogeo.pl.linear.model.RoleDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AppUserMapperImpl_.class, SetRoleMapperImpl.class, RoleMapperImpl_.class})
class AppUserMapperTest {
    @Autowired
    AppUserMapper appUserMapper;

    @Test
    void appUserToAppUserDto() {
        AppUser appUser = new AppUser();
        appUser.setUserId(UUID.randomUUID());
        appUser.setEmail("mk@wp.pl");
        appUser.setUsername("mk");
        appUser.setPassword("pass");
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(ERole.ROLE_USER));
        roles.add(new Role(ERole.ROLE_ADMIN));
        appUser.setRoles(roles);
        AppUserDto appUserDto = appUserMapper.appUserToAppUserDto(appUser);
        assertThat(appUserDto.getEmail()).isEqualTo("mk@wp.pl");
        Set<RoleDto> roleDtoSet = new HashSet<>();
        roleDtoSet = appUserDto.getRoles();
        assertThat(roleDtoSet).anyMatch(roleDto -> roleDto.getRolename().contentEquals("admin"));
    }

    @Test
    void appUserDtoToAppUser() {
    }
}