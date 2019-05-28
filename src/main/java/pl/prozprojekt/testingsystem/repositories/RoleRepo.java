package pl.prozprojekt.testingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.prozprojekt.testingsystem.entities.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
}
