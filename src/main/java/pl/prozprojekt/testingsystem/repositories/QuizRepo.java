package pl.prozprojekt.testingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.prozprojekt.testingsystem.entities.Quiz;

import java.util.List;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Long> {
    List<Quiz> getQuizzesByStudentGroupId(Long id);
}