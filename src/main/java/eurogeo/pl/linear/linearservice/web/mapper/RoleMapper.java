package eurogeo.pl.linear.linearservice.web.mapper;


import eurogeo.pl.linear.linearservice.domain.ERole;
import eurogeo.pl.linear.linearservice.domain.Role;
import eurogeo.pl.linear.model.RoleDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
@DecoratedWith(RoleMapperDecorator.class)
public interface RoleMapper {



     Role roleDtoToRole(RoleDto roleDto);



    RoleDto roleToRoleDto(Role role);

    default String toString(ERole erole){
        return erole.getCode();
    }
    default ERole toErole(String code){
        for (ERole testEnum : ERole.values()) {
            if(testEnum.getCode().equals(code)){
                return testEnum;
            }
        }
        return null;
    }

}
