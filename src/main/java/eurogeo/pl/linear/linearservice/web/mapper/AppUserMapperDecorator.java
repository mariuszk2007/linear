package eurogeo.pl.linear.linearservice.web.mapper;

import eurogeo.pl.linear.linearservice.domain.AppUser;
import eurogeo.pl.linear.model.AppUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class AppUserMapperDecorator implements  AppUserMapper{
    private  AppUserMapper mapper;
    @Autowired
    public void setMapper(AppUserMapper mapper){
        this.mapper = mapper;
        }

    @Override
    public AppUserDto appUserToAppUserDto(AppUser appUser) {
        return mapper.appUserToAppUserDto(appUser);
    }

    @Override
    public AppUser appUserDtoToAppUser(AppUserDto appUserDto) {
        return mapper.appUserDtoToAppUser(appUserDto);
    }
}
