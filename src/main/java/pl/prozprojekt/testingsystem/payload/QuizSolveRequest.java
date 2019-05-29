package pl.prozprojekt.testingsystem.payload;

import javax.validation.constraints.NotNull;
import java.util.List;

public class QuizSolveRequest {

    @NotNull
    private Long quizId;

    @NotNull
    private List<Integer> answers;

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public List<Integer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Integer> answers) {
        this.answers = answers;
    }
}
