package pl.prozprojekt.testingsystem.mappers;

import org.springframework.stereotype.Service;
import pl.prozprojekt.testingsystem.entities.SolvedQuiz;
import pl.prozprojekt.testingsystem.views.SolvedQuizView;

import java.util.ArrayList;
import java.util.List;

@Service
public class SolvedQuizMapper implements Mapper<SolvedQuiz, SolvedQuizView>{
    @Override
    public SolvedQuizView convertToView(SolvedQuiz solved)
    {
        SolvedQuizView solvedView = new SolvedQuizView();
        solvedView.setId(solved.getId());
        List<Integer> answers = new ArrayList<>();
        char[] stringAnswers= solved.getAnswers().toCharArray();
        for(char a: stringAnswers){
            answers.add(Character.getNumericValue(a));
        }
        solvedView.setAnswers(answers);
        solvedView.setScore(solved.getScore());
        solvedView.setPercent(solved.getPercent());
        solvedView.setName(solved.getQuiz().getName());
        solvedView.setStudent(solved.getStudent().getName());
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
