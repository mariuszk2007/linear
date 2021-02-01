package eurogeo.pl.linear.linearservice.web.controller;

import eurogeo.pl.linear.linearservice.payloads.request.SingupRequest;
import eurogeo.pl.linear.linearservice.payloads.response.JwtResponse;
import eurogeo.pl.linear.linearservice.payloads.response.MessageResponse;
import eurogeo.pl.linear.linearservice.services.RoleService;
import eurogeo.pl.linear.linearservice.services.UserService;
import eurogeo.pl.linear.model.AppUserDto;
import eurogeo.pl.linear.model.RoleDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
public class UserController {


    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final RoleService roleService;

    public UserController(UserService userService, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, RoleService roleService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.roleService = roleService;
    }

    @GetMapping("/")
    public String hello(){
        return "hello";
    }
    @GetMapping("/secured")
    public String helloSecured() {
        return "hello secured";
    }

    @GetMapping("/current")
    public ResponseEntity currentUser(@RequestParam String username){

        return ResponseEntity
                .ok()
                .body(getUser(username));
    }
    @GetMapping("/userId")
    public ResponseEntity currentUser(@RequestParam UUID userId){

        return ResponseEntity
                .ok()
                .body(getUserById(userId));
    }

    private JwtResponse getUser(String username) {
        AppUserDto user = userService.getUserByUsername(username);

        return new JwtResponse( user.getUserId(), user.getUsername(), user.getEmail(),
                user.getRoles().stream().map(role -> role.getRolename()).collect(Collectors.toSet()));
    }
    private JwtResponse getUserById(UUID userId) {
        AppUserDto user = userService.getUserByUserId(userId);

        return new JwtResponse( user.getUserId(), user.getUsername(), user.getEmail(),
                user.getRoles().stream().map(role -> role.getRolename()).collect(Collectors.toSet()));
    }




    @PostMapping("/sign-up")
    public ResponseEntity signUp(@RequestBody SingupRequest singupRequest) {
        if (userService.existUserByUsername(singupRequest.getUsername())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("nazwa użytkownika jest już zajęta"));
        }
        if (userService.existUserByEmil(singupRequest.getEmail())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("istnieje juz użytkownik o tym adresie email"));
        }
        AppUserDto appUserDto = new AppUserDto();
        appUserDto.setUsername(singupRequest.getUsername());
        appUserDto.setEmail(singupRequest.getEmail());
        appUserDto.setPassword(passwordEncoder.encode(singupRequest.getPassword()));
        Set<String> strRoles = singupRequest.getRole();
        Set<RoleDto> roles = new HashSet<>();
        if(strRoles==null) {
           RoleDto roleDto =  roleService.save(new RoleDto("user"));
            roles.add(roleDto);
        }else {
            strRoles.forEach(roleName -> {
                switch (roleName) {
                    case "admin":

                       addNewRole(roleName);
                       roles.add(roleService.findByRolename(roleName));
                        break;

                    case "mod":

                        addNewRole(roleName);
                        roles.add(roleService.findByRolename(roleName));
                        break;
                    default:
                        roleName="user";
                        addNewRole(roleName);
                        roles.add(roleService.findByRolename(roleName));
                }
            });
        }
        appUserDto.setRoles(roles);
        userService.save(appUserDto);
        return ResponseEntity.ok(new MessageResponse("Użytkownik poprawnie zarejestrowany"));
    }


    private void addNewRole(String roleName){

        if(roleService.existByRolename(roleName)==false) {
            roleService.save(new RoleDto(roleName));
        }


    }
   }

