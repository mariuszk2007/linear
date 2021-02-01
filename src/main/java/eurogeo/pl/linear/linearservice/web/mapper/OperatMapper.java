package eurogeo.pl.linear.linearservice.web.mapper;

import eurogeo.pl.linear.linearservice.domain.Operat;
import eurogeo.pl.linear.model.OperatDto;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring", uses = {DateMapper.class})
@DecoratedWith(OperatMapperDecorator.class)
public interface OperatMapper {
    @Mappings(
            {@Mapping(source = "projektId", target="projekt.projektId"),
             @Mapping(source ="createUser", target="createUser.userId"),
             @Mapping(source ="updateUser", target="updateUser.userId")
            })
        Operat operatDtoToOperat(OperatDto operatDto);
    @Mappings({
             @Mapping(source = "projekt.projektId", target="projektId"),
             @Mapping(source ="createUser.userId", target="createUser"),
             @Mapping(source ="updateUser.userId", target="updateUser")
    })
        OperatDto operatToOperatDto(Operat operat);
}
