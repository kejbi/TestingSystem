package pl.prozprojekt.testingsystem.mappers;

import org.springframework.stereotype.Component;
import pl.prozprojekt.testingsystem.entities.Question;
import pl.prozprojekt.testingsystem.views.QuestionView;

@Component
public class QuestionMapper implements Mapper<Question, QuestionView> {
    @Override
    public QuestionView convertToView(Question q)
    {
        QuestionView view = new QuestionView();

        view.setAnswers(q.getAnswers());
        view.setQuestion(q.getQuestion());
        view.setQuestionId(q.getId());
        view.setCorrect(-1);

        return view;
    }

    @Override
    public Question convertToEntity(QuestionView view)
    {
        Question q = new Question();

        q.setQuestion(view.getQuestion());
        q.setAnswers(view.getAnswers());
        q.setId(view.getQuestionId());
        q.setCorrect(view.getCorrect());

        return q;
    }
}
