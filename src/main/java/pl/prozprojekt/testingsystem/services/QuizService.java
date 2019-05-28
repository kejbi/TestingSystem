package pl.prozprojekt.testingsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.prozprojekt.testingsystem.entities.Quiz;
import pl.prozprojekt.testingsystem.repositories.QuizRepo;


import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    private QuizRepo quizRepo;

    @Autowired
    public QuizService(QuizRepo quizRepo) {
        this.quizRepo = quizRepo;
    }

    public Optional<Quiz> getQuizById(Long id){ return quizRepo.findById(id); }

    public List<Quiz> getAllQuizzes(){
        return quizRepo.findAll();
    }

    public List<Quiz> getQuizzesByGroupId(Long id){ return quizRepo.getQuizzesByStudentGroupId(id);}

    public List<Quiz> getQuizzesByTeacherId(Long id){
        return quizRepo.getQuizzesByTeacherId(id);
    }

    public void addQuiz(Quiz quiz){ quizRepo.save(quiz); }

    public void deleteQuizById(Long id){ quizRepo.deleteById(id); }
}
