package pl.prozprojekt.testingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.prozprojekt.testingsystem.entities.Quiz;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Long> {
}