package pl.prozprojekt.testingsystem.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
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
@Secured({"ROLE_STUDENT", "ROLE_TEACHER"})
public class SolvedQuizController {
    private SolvedQuizService solvedService;
    private SolvedQuizMapper solvedMapper;
    private QuizService quizService;
    private StudentService studentService;

    @Autowired
    public SolvedQuizController(SolvedQuizService solvedService, SolvedQuizMapper solvedMapper, QuizService quizService, StudentService studentService)
    {
        this.solvedService = solvedService;
        this.solvedMapper = solvedMapper;
        this.quizService = quizService;
        this.studentService = studentService;
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

    @GetMapping("/student/{id}")
    public List<SolvedQuizView> getSolvedQuizzesByStudentId(@PathVariable Long id){
        return solvedService.getSolvedQuizzesByStudentId(id).stream().map(solvedQuiz -> solvedMapper.convertToView(solvedQuiz)).collect(Collectors.toList());
    }

    @GetMapping("/quiz/{id}")
    public List<SolvedQuizView> getSolvedQuizzesByQuizId(@PathVariable Long id){
        return solvedService.getSolvedQuizzesByQuizId(id).stream().map(solvedQuiz -> solvedMapper.convertToView(solvedQuiz)).collect(Collectors.toList());
    }

    @PostMapping
    public SolvedQuizView addSolved(@RequestBody @Valid QuizSolveRequest quizSolveRequest, BindingResult bidingResult){
        if(bidingResult.hasErrors()){
            throw new ValidationException();
        }

        List<Integer> answers = quizSolveRequest.getAnswers();
        String ans = "";
        int all = 0;
        int score = 0;
        Long id = quizSolveRequest.getQuizId();

        Quiz quiz = quizService.getQuizById(id).orElseThrow(EntityNotFoundException::new);
        Student student = studentService.getStudentById(quizSolveRequest.getStudentId()).orElseThrow(EntityNotFoundException::new);

        for(Question q: quiz.getQuestions()){
            if(answers.get(all) == q.getCorrect()) {
                score += 1;
            }
            ans += answers.get(all);
            all += 1;

        }

        SolvedQuiz solved = new SolvedQuiz();
        solved.setAnswers(ans);
        solved.setScore(score);
        solved.setQuiz(quiz);
        solved.setStudent(student);
        solved.setPercent((100*score)/all);
       ;
        return solvedMapper.convertToView(solvedService.addSolved(solved));
    }

    @DeleteMapping("/{id}")
    public void deleteSolvedById(@PathVariable Long id){
        solvedService.deleteSolvedById(id);
    }
}
