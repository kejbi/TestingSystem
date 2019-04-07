package pl.prozprojekt.testingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.prozprojekt.testingsystem.entities.Teacher;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long> {

}
