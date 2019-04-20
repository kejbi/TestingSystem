package pl.prozprojekt.testingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.prozprojekt.testingsystem.entities.StudentGroup;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepo extends JpaRepository<StudentGroup, Long> {
}
