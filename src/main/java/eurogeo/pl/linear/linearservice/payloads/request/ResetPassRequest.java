package eurogeo.pl.linear.linearservice.payloads.request;

import lombok.Data;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class ResetPassRequest {

    @Email
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String token;
}
