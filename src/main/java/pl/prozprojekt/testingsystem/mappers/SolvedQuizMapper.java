package pl.prozprojekt.testingsystem.mappers;

import org.springframework.stereotype.Service;
import pl.prozprojekt.testingsystem.entities.SolvedQuiz;
import pl.prozprojekt.testingsystem.views.SolvedQuizView;

@Service
public class SolvedQuizMapper implements Mapper<SolvedQuiz, SolvedQuizView>{
    @Override
    public SolvedQuizView convertToView(SolvedQuiz solved)
    {
        SolvedQuizView solvedView = new SolvedQuizView();
        solvedView.setId(solved.getId());
        return solvedView;
    }

    @Override
    public SolvedQuiz convertToEntity(SolvedQuizView solvedView)
    {
        SolvedQuiz solved = new SolvedQuiz();
        solved.setId(solvedView.getId());
        return solved;
    }
}
