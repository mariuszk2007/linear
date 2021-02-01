package eurogeo.pl.linear.linearservice.web.mapper;

import eurogeo.pl.linear.linearservice.domain.Projekt;
import eurogeo.pl.linear.model.ProjektDto;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ProjektMapperDecorator implements ProjektMapper{
    private ProjektMapper mapper;

    @Autowired
    public void setMapper(ProjektMapper mapper) {
        this.mapper = mapper;
    }


    @Override
    public ProjektDto projektToProjektDto(Projekt projekt){
        return mapper.projektToProjektDto(projekt);
    }
    @Override
    public Projekt projektDtoToProjekt(ProjektDto projektDto){
        return mapper.projektDtoToProjekt(projektDto);
    }
}
