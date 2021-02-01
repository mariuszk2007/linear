package eurogeo.pl.linear.linearservice.web.mapper;

import eurogeo.pl.linear.linearservice.domain.Projekt;
import eurogeo.pl.linear.model.ProjektDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {DateMapper.class})
@DecoratedWith(ProjektMapperDecorator.class)
public interface ProjektMapper {

    ProjektDto projektToProjektDto(Projekt projekt);
    Projekt projektDtoToProjekt(ProjektDto projektDto);
}
