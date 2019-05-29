package pl.prozprojekt.testingsystem.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.prozprojekt.testingsystem.entities.Question;
import pl.prozprojekt.testingsystem.entities.Quiz;
import pl.prozprojekt.testingsystem.entities.SolvedQuiz;
import pl.prozprojekt.testingsystem.entities.Student;
import pl.prozprojekt.testingsystem.mappers.SolvedQuizMapper;
import pl.prozprojekt.testingsystem.payload.QuizSolveRequest;
import pl.prozprojekt.testingsystem.services.QuizService;
import pl.prozprojekt.testingsystem.services.SolvedQuizService;
import pl.prozprojekt.testingsystem.services.StudentService;
import pl.prozprojekt.testingsystem.views.SolvedQuizView;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/solved")
public class SolvedQuizController {
    private SolvedQuizService solvedService;
    private SolvedQuizMapper solvedMapper;
    private QuizService quizService;
    private StudentService studentService;

    @Autowired
    public SolvedQuizController(SolvedQuizService solvedService, SolvedQuizMapper solvedMapper)
    {
        this.solvedService = solvedService;
        this.solvedMapper = solvedMapper;
    }

    @GetMapping("/{id}")
    public SolvedQuizView getSolvedById(@PathVariable Long id){
        SolvedQuiz solved = solvedService.getSolvedById(id).orElseThrow(EntityNotFoundException::new);
        return solvedMapper.convertToView(solved);
    }

    @GetMapping
    public List<SolvedQuizView> getAllSolved(){
        return solvedService.getAllSolved().stream().map(solved->solvedMapper.convertToView(solved)).collect(Collectors.toList());
    }

    @PostMapping
    public void addSolved(@RequestBody @Valid QuizSolveRequest quizSolveRequest, BindingResult bidingResult){
        if(bidingResult.hasErrors()){
            throw new ValidationException();
        }
        List<Integer> answers = quizSolveRequest.getAnswers();
        String ans = new String();
        int all = 0;
        int score = 0;
        Long id = quizSolveRequest.getQuizId();
        Quiz quiz = quizService.getQuizById(id).orElseThrow(EntityNotFoundException::new);
        Student student = studentService.getStudentById(quizSolveRequest.getStudentId()).orElseThrow(EntityNotFoundException::new);

        for(Question q: quiz.getQuestions()){
            if(answers.get(all) == q.getCorrect()) {
                score += 1;
            }
            all += 1;
            ans += answers.get(all);
        }

        SolvedQuiz solved = new SolvedQuiz();
        solved.setAnswers(ans);
        solved.setScore(score);
        solved.setQuiz(quiz);
        solved.setStudent(student);
        solvedService.addSolved(solved);
    }

    @DeleteMapping("/{id}")
    public void deleteSolvedById(@PathVariable Long id){
        solvedService.deleteSolvedById(id);
    }
}
