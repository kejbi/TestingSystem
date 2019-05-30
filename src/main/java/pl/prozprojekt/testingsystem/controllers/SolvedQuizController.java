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
import pl.prozprojekt.testingsystem.services.QuizSolver;
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
    private QuizSolver quizSolver;

    @Autowired
    public SolvedQuizController(SolvedQuizService solvedService, SolvedQuizMapper solvedMapper, QuizSolver quizSolver)
    {
        this.solvedService = solvedService;
        this.solvedMapper = solvedMapper;
        this.quizSolver = quizSolver;
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

        SolvedQuiz solved = quizSolver.solveQuiz(quizSolveRequest);

        return solvedMapper.convertToView(solvedService.addSolved(solved));
    }

    @DeleteMapping("/{id}")
    public void deleteSolvedById(@PathVariable Long id){
        solvedService.deleteSolvedById(id);
    }
}
