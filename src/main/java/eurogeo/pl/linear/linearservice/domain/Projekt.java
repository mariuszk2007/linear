package eurogeo.pl.linear.linearservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "projekt")
public class Projekt {


    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type="org.hibernate.type.UUIDCharType")
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false, name="projectId")
    private UUID projektId;
    @Version
    private Long version;
    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdDate;
    @UpdateTimestamp
    private Timestamp lastModifiedDate;
    @NotBlank
    private String projektName;

    private String projektDescription;

    @OneToMany(mappedBy = "projekt")
    @EqualsAndHashCode.Exclude
    private  Set<Operat> operats = new HashSet<>();

    @JsonIgnore
    public void addOperat(Operat operat){
        operats.add(operat);
        operat.setProjekt(this);
    }
    @JsonIgnore
    public void removeOperat(Operat operat){
    operats.remove(operat);
    operat.setProjekt(null);
    }



}
