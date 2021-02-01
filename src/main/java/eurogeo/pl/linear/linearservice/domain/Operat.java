package eurogeo.pl.linear.linearservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "operat")
public class Operat {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type="org.hibernate.type.UUIDCharType")
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID id;
    @Version
    private Long version;
  //  @Column(updatable = false)
    @NotNull
    private Long operatNumber;

    @ManyToOne
    @JoinColumn(name="projekt_id", nullable = false, updatable = false)
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private Projekt projekt;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdDate;

    @UpdateTimestamp
    private Timestamp lastModifiedDate;
    @NotBlank
    private String layer;
    @NotNull
    private double odKm;
    @NotNull
    private double doKm;

    @ManyToOne
    @JoinColumn(name="createuser_id",  nullable = false, updatable = false)
    private AppUser createUser;

    @ManyToOne
    @JoinColumn(name="updateuser_id",  nullable = false)
    private AppUser updateUser;


}
