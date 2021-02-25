package eurogeo.pl.linear.linearservice.services;

import eurogeo.pl.linear.linearservice.domain.AppUser;
import eurogeo.pl.linear.linearservice.repositories.UserRepository;
import eurogeo.pl.linear.linearservice.web.mapper.AppUserMapper;
import eurogeo.pl.linear.model.AppUserDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AppUserMapper appUserMapper;

    @Override
    public AppUserDto save(AppUserDto appUserDto) {
        return appUserMapper.appUserToAppUserDto(userRepository.save(appUserMapper.appUserDtoToAppUser(appUserDto)));
    }

    @Override
    public AppUserDto getUserByUsername(String username) {
        AppUser appUser = userRepository.findByUsername(username);
        return appUserMapper.appUserToAppUserDto(appUser);
    }

    @Override
    public AppUserDto getUserByEmail(String email) {
        AppUser appUser = userRepository.findByEmail(email);
        return appUserMapper.appUserToAppUserDto(appUser);
    }

    @Override
    public boolean existUserByUsername(String username) {

        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean existUserByEmail(String email) {

        return userRepository.existsByEmail(email);
    }

    @Override
    public AppUserDto getUserByUserId(UUID userId) {
        return appUserMapper.appUserToAppUserDto(userRepository.findByUserId(userId));
    }
}
