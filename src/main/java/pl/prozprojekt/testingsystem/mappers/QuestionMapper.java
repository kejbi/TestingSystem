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

        view.setAns1(q.getAns1());
        view.setAns2(q.getAns2());
        view.setAns3(q.getAns3());
        view.setAns4(q.getAns4());
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
        q.setAns1(view.getAns1());
        q.setAns2(view.getAns2());
        q.setAns3(view.getAns3());
        q.setAns4(view.getAns4());
        q.setId(view.getQuestionId());
        q.setCorrect(view.getCorrect());

        return q;
    }
}
