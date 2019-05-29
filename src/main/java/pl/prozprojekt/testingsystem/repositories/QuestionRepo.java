package pl.prozprojekt.testingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.prozprojekt.testingsystem.entities.Question;
import org.springframework.stereotype.Repository;
import pl.prozprojekt.testingsystem.entities.Quiz;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long> {
    @Query( value = "select q.* from question q, quiz_question qq where qq.quiz_id=?1 and q.id=qq.question_id ", nativeQuery = true)
    List<Question> findQuestionsByQuizId(Long id);

    List<Question> findAllByIdIn(List<Long> list);
}
