package eurogeo.pl.linear.linearservice.services;

import eurogeo.pl.linear.model.AppUserDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface UserService {
    AppUserDto save(AppUserDto appUserDto);
    AppUserDto getUserByUsername(String username);
    AppUserDto getUserByEmail(String email);
    boolean existUserByUsername(String username);
    boolean existUserByEmail(String email);
    AppUserDto getUserByUserId(UUID userId);


}
