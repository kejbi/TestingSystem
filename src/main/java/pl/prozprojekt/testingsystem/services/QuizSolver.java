package pl.prozprojekt.testingsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.prozprojekt.testingsystem.entities.Question;
import pl.prozprojekt.testingsystem.entities.Quiz;
import pl.prozprojekt.testingsystem.entities.SolvedQuiz;
import pl.prozprojekt.testingsystem.entities.Student;
import pl.prozprojekt.testingsystem.payload.QuizSolveRequest;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class QuizSolver {
    private QuizService quizService;
    private StudentService studentService;

    @Autowired
    public QuizSolver(QuizService quizService, StudentService studentService) {
        this.quizService = quizService;
        this.studentService = studentService;
    }

    public SolvedQuiz solveQuiz(QuizSolveRequest quizSolveRequest){
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
        return solved;
    }
}
