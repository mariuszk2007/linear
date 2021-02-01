package eurogeo.pl.linear.linearservice.repositories;


import eurogeo.pl.linear.linearservice.domain.Projekt;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.UUID;

public interface ProjektRepository extends JpaRepository<Projekt, UUID> {



}
