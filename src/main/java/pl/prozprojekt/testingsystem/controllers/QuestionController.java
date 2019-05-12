package pl.prozprojekt.testingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pl.prozprojekt.testingsystem.entities.Question;
import pl.prozprojekt.testingsystem.services.QuestionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    private QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public Optional<Question> getQuestionById(@RequestParam Long id){
        return questionService.getQuestionById(id);
    }

    @GetMapping("/all")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @PostMapping
    public void addQuestion(@RequestBody Question question){
        questionService.addQuestion(question);
    }

    @DeleteMapping
    public void deleteQuestionById(@RequestParam Long id){
        questionService.deleteQuestionById(id);
    }
}


