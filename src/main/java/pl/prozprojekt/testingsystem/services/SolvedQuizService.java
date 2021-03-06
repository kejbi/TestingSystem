package pl.prozprojekt.testingsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.prozprojekt.testingsystem.entities.SolvedQuiz;
import pl.prozprojekt.testingsystem.repositories.SolvedQuizRepo;

import java.util.List;
import java.util.Optional;

@Service
public class SolvedQuizService {
    private SolvedQuizRepo solvedRepo;

    @Autowired
    public SolvedQuizService(SolvedQuizRepo solvedRepo) {
        this.solvedRepo = solvedRepo;
    }

    public Optional<SolvedQuiz> getSolvedById(Long id){ return solvedRepo.findById(id); }

    public List<SolvedQuiz> getAllSolved(){
        return solvedRepo.findAll();
    }

    public List<SolvedQuiz> getSolvedQuizzesByStudentId(Long id){
        return solvedRepo.getSolvedQuizsByStudentId(id);
    }

    public List<SolvedQuiz> getSolvedQuizzesByQuizId(Long id){
        return solvedRepo.getSolvedQuizsByQuizId(id);
    }

    public SolvedQuiz addSolved(SolvedQuiz quiz){ return solvedRepo.save(quiz); }

    public void deleteSolvedById(Long id){ solvedRepo.deleteById(id); }
}
