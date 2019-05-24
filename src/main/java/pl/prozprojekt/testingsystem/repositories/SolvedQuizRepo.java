package pl.prozprojekt.testingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.prozprojekt.testingsystem.entities.SolvedQuiz;

@Repository
public interface SolvedQuizRepo extends JpaRepository<SolvedQuiz, Long> {
}
