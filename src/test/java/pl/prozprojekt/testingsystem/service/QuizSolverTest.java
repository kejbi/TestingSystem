package pl.prozprojekt.testingsystem.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.prozprojekt.testingsystem.payload.QuizSolveRequest;
import pl.prozprojekt.testingsystem.services.QuizSolver;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuizSolverTest {

    @Autowired
    private QuizSolver quizSolver;

    @Test
    public void whenSolveRequestGiven_thenReturnGoodSolvedTest(){

    }
}
