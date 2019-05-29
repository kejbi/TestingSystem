package pl.prozprojekt.testingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.prozprojekt.testingsystem.entities.SolvedQuiz;

import java.util.List;

@Repository
public interface SolvedQuizRepo extends JpaRepository<SolvedQuiz, Long> {

    List<SolvedQuiz> getSolvedQuizsByStudentId(Long id);

    List<SolvedQuiz> getSolvedQuizsByQuizId(Long id);
}
