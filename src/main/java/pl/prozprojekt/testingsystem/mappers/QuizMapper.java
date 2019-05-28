package pl.prozprojekt.testingsystem.mappers;

import org.springframework.stereotype.Service;
import pl.prozprojekt.testingsystem.views.QuizView;
import pl.prozprojekt.testingsystem.entities.Quiz;

@Service
public class QuizMapper implements Mapper<Quiz, QuizView>{
@Override
 public QuizView convertToView(Quiz quiz)
 {
     QuizView quizView = new QuizView();
     quizView.setId(quiz.getId());
     quizView.setName(quiz.getName());
     return quizView;
 }

 @Override
 public Quiz convertToEntity(QuizView quizView)
 {
     Quiz quiz = new Quiz();
     quiz.setId(quizView.getId());
     quiz.setName(quizView.getName());
     return quiz;
 }
}
