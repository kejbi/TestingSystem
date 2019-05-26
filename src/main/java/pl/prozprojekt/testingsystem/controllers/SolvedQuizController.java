package pl.prozprojekt.testingsystem.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.prozprojekt.testingsystem.entities.SolvedQuiz;
import pl.prozprojekt.testingsystem.mappers.SolvedQuizMapper;
import pl.prozprojekt.testingsystem.services.SolvedQuizService;
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
    public void addSolved(@RequestBody @Valid SolvedQuiz solved, BindingResult bidingResult){
        if(bidingResult.hasErrors()){
            throw new ValidationException();
        }
        solvedService.addSolved(solved);
    }

    @DeleteMapping("/{id}")
    public void deleteSolvedById(@PathVariable Long id){
        solvedService.deleteSolvedById(id);
    }
}
