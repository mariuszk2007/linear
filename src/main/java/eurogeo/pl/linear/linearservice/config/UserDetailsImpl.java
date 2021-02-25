package eurogeo.pl.linear.linearservice.config;

import eurogeo.pl.linear.linearservice.domain.AppUser;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
public class UserDetailsImpl implements UserDetails {

    private UUID id;
    private String username;
    private String email;
    private String password;
    private String token;
    private Collection<? extends GrantedAuthority> authorities;

    private UserDetailsImpl(UUID id, String username, String email, String password, String token, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.token = token;
        this.authorities = authorities;
    }
    public static UserDetailsImpl build(AppUser appUser){
        List<GrantedAuthority> authorities = appUser.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRolename().name()))
                .collect(Collectors.toList());
        return new UserDetailsImpl(
                appUser.getUserId(),
                appUser.getUsername(),
                appUser.getEmail(),
                appUser.getPassword(),
                appUser.getToken(),
                authorities );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    @Override
    public  boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl  user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }
}
