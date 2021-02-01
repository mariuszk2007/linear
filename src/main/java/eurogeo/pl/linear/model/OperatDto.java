package eurogeo.pl.linear.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperatDto implements Serializable {

    static final long serialVersionUID = 1650020694300907199L;

    @Id
    @Null
    private UUID id;
    @Null
    private Integer version;

    @NotNull
    private long operatNumber;
    @NotNull
    private UUID projektId;

    @Null
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssZ", shape=JsonFormat.Shape.STRING)
    private OffsetDateTime createdDate;

    @Null
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssZ", shape=JsonFormat.Shape.STRING)
    private OffsetDateTime lastModifiedDate;
    @NotBlank
    private String layer;
    @NotNull
    private double odKm;
    @NotNull
    private double doKm;
    @NotNull
    private UUID createUser;
    @NotNull
    private UUID updateUser;



}
