package eurogeo.pl.linear.linearservice.web.mapper;

import eurogeo.pl.linear.linearservice.domain.AppUser;
import eurogeo.pl.linear.model.AppUserDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", uses = {RoleMapper.class, SetRoleMapper.class})
@DecoratedWith(AppUserMapperDecorator.class)

public interface AppUserMapper {


    AppUserDto appUserToAppUserDto(AppUser appUser);
    AppUser appUserDtoToAppUser(AppUserDto appUserDto);
}
