package pl.prozprojekt.testingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.prozprojekt.testingsystem.entities.Teacher;

import java.util.Optional;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long> {

    public Optional<Teacher> findTeacherByName(String name);

}
