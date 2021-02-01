package eurogeo.pl.linear.linearservice.services;


import eurogeo.pl.linear.model.ProjektDto;

import java.util.Set;
import java.util.UUID;

public interface ProjektService {
    Set<ProjektDto> projektSet();
    ProjektDto getProjektDtoById(UUID projektId);
    ProjektDto saveNewProjekt(ProjektDto projektDto);
   ProjektDto updateProjekt(ProjektDto projektDto);


}
