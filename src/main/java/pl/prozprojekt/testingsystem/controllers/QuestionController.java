package pl.prozprojekt.testingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pl.prozprojekt.testingsystem.entities.Question;
import pl.prozprojekt.testingsystem.mappers.QuestionMapper;
import pl.prozprojekt.testingsystem.services.QuestionService;
import pl.prozprojekt.testingsystem.views.QuestionView;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    private QuestionService questionService;
    private QuestionMapper questionMapper;

    @Autowired
    public QuestionController(QuestionService questionService, QuestionMapper questionMapper) {
        this.questionService = questionService;
        this.questionMapper = questionMapper;
    }

    @GetMapping
    public Optional<Question> getQuestionById(@RequestParam Long id){
        return questionService.getQuestionById(id);
    }

    @GetMapping("/all")
    public List<QuestionView> getAllQuestions(){
        return questionService.getAllQuestions().stream()
                .map(question -> questionMapper.convertToView(question))
                .collect(Collectors.toList());
    }

    @GetMapping("/quiz/{id}")
    public List<QuestionView> getQuestionsByQuizId(@PathVariable Long id){
        return questionService.getQuestionsByQuizId(id)
                .stream()
                .map(question -> questionMapper.convertToView(question))
                .collect(Collectors.toList());
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


