package eurogeo.pl.linear.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.UUID;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {

    @Id
    @Null
    private Integer id;

    @NotNull
    private String rolename;

    public RoleDto(@NotNull String rolename) {
        this.rolename = rolename;
    }
}
