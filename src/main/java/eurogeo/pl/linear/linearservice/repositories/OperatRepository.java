package eurogeo.pl.linear.linearservice.repositories;

import eurogeo.pl.linear.linearservice.domain.Operat;
import eurogeo.pl.linear.linearservice.domain.Projekt;
import eurogeo.pl.linear.model.OperatDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface OperatRepository extends CrudRepository<Operat, UUID> {

List<Operat> findAllByLayer(String layer);
Operat findByOperatNumberAndProjekt(long operatNumber, Projekt projekt);
List<Operat> findAllByProjektAndLayerContainingOrderByOperatNumber(Projekt projekt, String layer);
List<Operat> findAllByProjektOrderByOperatNumber(Projekt projekt);
List<Operat> findAllByOdKmLessThanEqualAndDoKmGreaterThanEqualAndProjektOrderByOperatNumber(double odKm, double doKm,
                                                                           Projekt projekt);
List<Operat> findAllByOdKmBetweenAndProjektOrDoKmBetweenAndProjektOrOdKmLessThanEqualAndDoKmGreaterThanEqualAndProjektOrderByOperatNumber(double odKmFrom, double odKmTo,Projekt projekt, double doKmFrom, double doKmTo,
                                                                                      Projekt projekt2,double odKm, double doKm,Projekt projekt3);
List<Operat> findAllByOdKmLessThanEqualAndProjektOrderByOperatNumber(double odKm,Projekt projekt);


}
