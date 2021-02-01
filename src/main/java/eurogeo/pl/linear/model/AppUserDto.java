package eurogeo.pl.linear.model;

import eurogeo.pl.linear.linearservice.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUserDto  implements Serializable {

    static final long serialVersionUID = -8347587346599289612L;

    @Id
    @Null
    private UUID userId;
    @NotNull
    private String username;
    @NotNull

    private String email;
    @NotNull
    private String password;

    @Builder.Default
    private Set<RoleDto> roles = new HashSet<>();
}
