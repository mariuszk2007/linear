package eurogeo.pl.linear.linearservice.repositories;


import eurogeo.pl.linear.linearservice.domain.ERole;
import eurogeo.pl.linear.linearservice.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {


  Role findByRolename(ERole name);
  Boolean existsByRolename(ERole name);

}
