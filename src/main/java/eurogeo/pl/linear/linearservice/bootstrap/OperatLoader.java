package eurogeo.pl.linear.linearservice.bootstrap;

import eurogeo.pl.linear.linearservice.domain.*;
import eurogeo.pl.linear.linearservice.repositories.OperatRepository;
import eurogeo.pl.linear.linearservice.repositories.ProjektRepository;
import eurogeo.pl.linear.linearservice.repositories.RoleRepository;
import eurogeo.pl.linear.linearservice.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@RequiredArgsConstructor
@Component
@Slf4j
public class OperatLoader implements CommandLineRunner {

    public static final String OPERAT_1 = "0631234200036";
    public static final String OPERAT_2 = "0631234300019";
    public static final String OPERAT_3 = "0083783375213";

    private final OperatRepository operatRepository;
    private final ProjektRepository projektRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        if(operatRepository.count() == 0 ) {
           loadOperatObjects();
        }
    }

    private void loadOperatObjects() {
        Projekt projekt1= Projekt.builder()
                .projektName("E59")
                .build();
        Projekt projekt2= Projekt.builder()
                .projektName("Kornik Promenada")
                .build();
        projektRepository.save(projekt1);
        projektRepository.save(projekt2);
        Role role = new Role();
        role.setRolename(ERole.ROLE_MODERATOR);
        System.out.println(role.getRolename().toString());

        roleRepository.save(role);

        Set<Role> roles = new HashSet<>();
        roles.add(role);
        AppUser appUser = AppUser.builder()
                .username("temp")
                .email("temp@temp.com")
                .password("test")
                .roles(roles)
                .build();
    //   if(userRepository.existsByUsername(appUser.getUsername())==null) {
            System.out.println("create user *****************************************************************");
            userRepository.save(appUser);
    //   }
        Operat operat1 = Operat.builder()
                .operatNumber(1l)
                .projekt(projekt1)
                .layer("Stabilizacja 20cm")
                .odKm(34521)
                .doKm(35451)
                .createUser(appUser)
                .updateUser(appUser)
                .build();

        Operat operat2 = Operat.builder()
                .operatNumber(2l)
                .projekt(projekt1)
                .layer("Stabilizacja 20cm")
                .odKm(42541)
                .doKm(42600)
                .createUser(appUser)
                .updateUser(appUser)
                .build();
        Operat operat3 = Operat.builder()
                .operatNumber(3l)
                .projekt(projekt2)
                .layer("Subwarstwa")
                .odKm(42541)
                .doKm(42600)
                .createUser(appUser)
                .updateUser(appUser)
                .build();

        operatRepository.save(operat1);
        operatRepository.save(operat2);
        operatRepository.save(operat3);
    }
}
