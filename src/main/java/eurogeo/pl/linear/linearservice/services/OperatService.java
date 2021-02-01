package eurogeo.pl.linear.linearservice.services;

import eurogeo.pl.linear.linearservice.domain.Operat;
import eurogeo.pl.linear.model.OperatDto;
import eurogeo.pl.linear.model.OperatPagedList;
import eurogeo.pl.linear.model.ProjektDto;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.UUID;

public interface OperatService {


    OperatDto getByOperatIdAndProjectId(long operatId, UUID projektId);
    OperatDto saveNewOperat(OperatDto operatDto);
    OperatDto updateOperat(UUID operatId, OperatDto operatDto);
    List<OperatDto> getByProjectId(UUID projektId);
    List<OperatDto> listOperatsByLayer(UUID projektId, String layer);
    List<OperatDto> listOperatsBeetwenScope(double fromScope, double toScope,UUID projektId);
    List<OperatDto> listOperatsInScope(double fromScopeOd,double toScopeOd, UUID projektId,double fromScopeDo, double toScopeDo);
    List<OperatDto> listOperatsLessThan(double fromScope, UUID projektId);
}
