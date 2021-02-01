package eurogeo.pl.linear.linearservice.web.mapper;

import eurogeo.pl.linear.linearservice.domain.Operat;
import eurogeo.pl.linear.linearservice.domain.Projekt;
import eurogeo.pl.linear.model.OperatDto;
import eurogeo.pl.linear.model.ProjektDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



public abstract class OperatMapperDecorator implements OperatMapper{
    private OperatMapper mapper;

    @Autowired
    public void setMapper(OperatMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Operat operatDtoToOperat(OperatDto operatDto) {
        return mapper.operatDtoToOperat(operatDto);
    }

    @Override
    public OperatDto operatToOperatDto(Operat operat) {
        return mapper.operatToOperatDto(operat);
    }



}
