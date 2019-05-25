package pl.prozprojekt.testingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import pl.prozprojekt.testingsystem.entities.Quiz;
import pl.prozprojekt.testingsystem.mappers.QuizMapper;
import pl.prozprojekt.testingsystem.services.QuizService;
import pl.prozprojekt.testingsystem.views.QuizView;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/quizzes")
public class QuizController {
    private QuizService quizService;
    private QuizMapper quizMapper;
    @Autowired
    public QuizController(QuizService quizService, QuizMapper quizMapper)
    {
        this.quizService = quizService;
        this.quizMapper = quizMapper;
    }

    @GetMapping("/{id}")
    public QuizView getQuizById(@PathVariable Long id){
        Quiz quiz = quizService.getQuizById(id).orElseThrow(EntityNotFoundException::new);
        return quizMapper.convertToView(quiz);
    }

    @GetMapping
    public List<QuizView> getAllQuizzes(){
        return quizService.getAllQuizzes().stream().map(quiz->quizMapper.convertToView(quiz)).collect(Collectors.toList());
    }

    @PostMapping
    public void addQuiz(@RequestBody @Valid Quiz quiz, BindingResult bidingResult){
        if(bidingResult.hasErrors()){
            throw new ValidationException();
        }
        quizService.addQuiz(quiz);
    }

    @DeleteMapping("/{id}")
    public void deleteQuizById(@PathVariable Long id){
        quizService.deleteQuizById(id);
    }
}