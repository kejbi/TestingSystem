package pl.prozprojekt.testingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.prozprojekt.testingsystem.entities.Student;

import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    public Optional<Student> findStudentByName(String name);
}
