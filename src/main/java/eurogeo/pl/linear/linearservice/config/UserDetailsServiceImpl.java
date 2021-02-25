package eurogeo.pl.linear.linearservice.config;


import eurogeo.pl.linear.linearservice.domain.AppUser;
import eurogeo.pl.linear.linearservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       AppUser appuser = userRepository.findByUsername(username);
       if( appuser == null){
           appuser = userRepository.findByEmail(username);
       }
        if (appuser == null) {
            throw new UsernameNotFoundException(username);
        }
        return UserDetailsImpl.build(appuser);
    }
}
