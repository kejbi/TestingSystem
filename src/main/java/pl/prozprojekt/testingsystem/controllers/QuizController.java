package pl.prozprojekt.testingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import pl.prozprojekt.testingsystem.entities.Question;
import pl.prozprojekt.testingsystem.entities.Quiz;
import pl.prozprojekt.testingsystem.mappers.QuizMapper;
import pl.prozprojekt.testingsystem.payload.QuizCreateRequest;
import pl.prozprojekt.testingsystem.services.GroupService;
import pl.prozprojekt.testingsystem.services.QuestionService;
import pl.prozprojekt.testingsystem.services.QuizService;
import pl.prozprojekt.testingsystem.services.TeacherService;
import pl.prozprojekt.testingsystem.views.QuizView;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/quizzes")
@Secured({"ROLE_STUDENT", "ROLE_TEACHER"})
public class QuizController {
    private QuizService quizService;
    private QuizMapper quizMapper;
    private GroupService groupService;
    private QuestionService questionService;
    private TeacherService teacherService;

    @Autowired
    public QuizController(QuizService quizService, QuizMapper quizMapper, GroupService groupService, QuestionService questionService, TeacherService teacherService) {
        this.quizService = quizService;
        this.quizMapper = quizMapper;
        this.groupService = groupService;
        this.questionService = questionService;
        this.teacherService = teacherService;
    }



    @GetMapping("/{id}")
    public QuizView getQuizById(@PathVariable Long id){
        Quiz quiz = quizService.getQuizById(id).orElseThrow(EntityNotFoundException::new);
        return quizMapper.convertToView(quiz);
    }

    @GetMapping("/group/{id}")
    public List<QuizView> getQuizzesByGroupId(@PathVariable Long id){
        return quizService.getQuizzesByGroupId(id).stream()
                .map(quiz -> quizMapper.convertToView(quiz))
                .collect(Collectors.toList());
    }

    @GetMapping("/teacher/{id}")
    public List<QuizView> getQuizzesByTeacherId(@PathVariable Long id){
        return quizService.getQuizzesByTeacherId(id).stream()
                .map(quiz -> quizMapper.convertToView(quiz))
                .collect(Collectors.toList());
    }

    @GetMapping
    public List<QuizView> getAllQuizzes(){
        return quizService.getAllQuizzes().stream().map(quiz->quizMapper.convertToView(quiz)).collect(Collectors.toList());
    }

    @PostMapping
    public QuizView addQuiz(@RequestBody @Valid QuizCreateRequest quizCreateRequest, BindingResult bidingResult){
        if(bidingResult.hasErrors()){
            throw new ValidationException(bidingResult.toString());
        }
        Quiz quiz = new Quiz();
        quiz.setName(quizCreateRequest.getName());
        quiz.setStudentGroup(groupService.getGroupById(quizCreateRequest.getGroupId()).get());
        quiz.setTeacher(teacherService.getTeacherById(quizCreateRequest.getTeacherId()).get());
        List<Question> questionList = questionService.getAllQuestionsByIdIn(quizCreateRequest.getQuestions());
        quiz.setQuestions(questionList);

        return quizMapper.convertToView(quizService.addQuiz(quiz));
    }

    @DeleteMapping("/{id}")
    public void deleteQuizById(@PathVariable Long id){
        quizService.deleteQuizById(id);
    }
}