package eurogeo.pl.linear.linearservice.payloads.response;

import eurogeo.pl.linear.model.RoleDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
public class JwtResponse {

    private UUID userId;
    private String username;
    private String email;
    private Set<String> roles;


}
