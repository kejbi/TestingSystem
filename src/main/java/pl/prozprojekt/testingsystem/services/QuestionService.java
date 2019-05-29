package pl.prozprojekt.testingsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.prozprojekt.testingsystem.entities.Question;
import pl.prozprojekt.testingsystem.repositories.QuestionRepo;


import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    private QuestionRepo questionRepo;

    @Autowired
    public QuestionService(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

    public Optional<Question> getQuestionById(Long id){ return questionRepo.findById(id); }

    public List<Question> getAllQuestions(){
        return questionRepo.findAll();
    }

    public List<Question> getQuestionsByQuizId(Long id){
        return questionRepo.findQuestionsByQuizId(id);
    }

    public List<Question> getAllQuestionsByIdIn(List<Long> list){
        return questionRepo.findAllByIdIn(list);
    }

    public Question addQuestion(Question question){
        return questionRepo.save(question);
    }

    public void deleteQuestionById(Long id){
        questionRepo.deleteById(id);
    }
}
