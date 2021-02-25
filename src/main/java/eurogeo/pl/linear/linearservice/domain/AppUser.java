package eurogeo.pl.linear.linearservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "appusers")
public class AppUser implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type="org.hibernate.type.UUIDCharType")
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID userId;
    @NotNull
    private String username;

    @Email
    private String email;

    @NotNull
    @Column(length = 68)
    private String password;

    private String token;

    @ManyToMany(fetch = FetchType.EAGER)
    @Builder.Default
    @JoinTable(name="appuser_roles",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name= "role_id"))
    private Set<Role> roles = new HashSet<>();



    public AppUser(@NonNull String username, @Email String email, String password, String token) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.token = token;
    }


}
