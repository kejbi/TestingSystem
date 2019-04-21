package pl.prozprojekt.testingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pl.prozprojekt.testingsystem.entities.Quiz;
import pl.prozprojekt.testingsystem.services.QuizService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/quizzes")
public class QuizController {
    private QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping
    public Optional<Quiz> getQuizById(@RequestParam Long id){ return quizService.getQuizById(id); }

    @GetMapping("/all")
    public List<Quiz> getAllQuizzes(){
        return quizService.getAllQuizzes();
    }

    @PostMapping
    public void addQuiz(@RequestBody Quiz quiz){
        quizService.addQuiz(quiz);
    }

    @DeleteMapping
    public void deleteQuizById(@RequestParam Long id){
        quizService.deleteQuizById(id);
    }
}