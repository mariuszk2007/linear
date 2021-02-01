package eurogeo.pl.linear.linearservice.repositories;


import eurogeo.pl.linear.linearservice.domain.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<AppUser, UUID> {

    AppUser findByUsername(String userName);

    AppUser findByEmail(String email);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    AppUser findByUserId(UUID userId);
}
