package eurogeo.pl.linear.linearservice.payloads.request;

import eurogeo.pl.linear.model.RoleDto;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
public class SingupRequest {

    @NotBlank
    private String username;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;
    private Set<String> role;

}
