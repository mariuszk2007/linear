package eurogeo.pl.linear.linearservice.payloads.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
