package pl.prozprojekt.testingsystem.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.prozprojekt.testingsystem.services.*;
import pl.prozprojekt.testingsystem.entities.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    private StudentService studentService;
    private TeacherService teacherService;
    private QuizService quizService;
    private QuestionService questionService;
    private GroupService groupService;

    @Autowired
    public DataLoader(StudentService studentService, TeacherService teacherService, QuizService quizService, QuestionService questionService, GroupService groupService)
    {
        this.quizService = quizService;
        this.studentService = studentService;
        this.teacherService = teacherService;
        this.questionService = questionService;
        this.groupService = groupService;
    }
    @Override
    public void run(String... strings)
    {


        Question question1 = new Question();
        question1.setQuestion("Kubek wazy 2kg i 1/2 kubka. Ile wazy kubek?");
        question1.setAns1("3.5kg");
        question1.setAns2("4kg");
        question1.setAns3("1kg");
        question1.setAns4("6kg");
        question1.setCorrect(2);
        Question question2 = new Question();
        question2.setQuestion("W jakich kolorach sa literki 'o' w logu firmy Google?");
        question2.setAns1("Niebieski i zielony");
        question2.setAns2("Zolty i czerwony");
        question2.setAns3("Zolty i niebieski");
        question2.setAns4("Zielony i czerwony");
        question2.setCorrect(2);
        Question question3 = new Question();
        question3.setQuestion("Ile pytan potrzeba, aby skutecznie poderwac dziewczyne z UW?");
        question3.setAns1("1");
        question3.setAns2("10");
        question3.setAns3("5");
        question3.setAns4("17");
        question3.setCorrect(2);
        Question question4 = new Question();
        question4.setQuestion("Co trzeba zrobic, jezeli Mips (znany kazdemu, kto chodzil na ARKO), zaczyna wolno dzialac?");
        question4.setAns1("Wylaczyc Mipsa i wlaczyc go ponownie.");
        question4.setAns2("Wylaczyc dostep do internetu na komputerze.");
        question4.setAns3("Wyczyscic rejestry");
        question4.setAns4("Dodac flage -Faster przy kompilacji programu w konsolii Mipsa.");
        question4.setCorrect(1);

        List <Question> questionlist1 = Arrays.asList(question1, question2);
        List <Question> questionlist2 = Arrays.asList(question3, question4);
        List <Question> questionlist3 = Arrays.asList(question2, question4);
        List <Question> questionlist4 = Arrays.asList(question1, question3);

        Teacher teacher = new Teacher();
        teacher.setId(1);
        teacher.setName("Jan_Kowalski");
        teacher.setPassword("{noop}password");

        Teacher teacher2 = new Teacher();
        teacher2.setId(2);
        teacher2.setName("Pawel_Szef");
        teacher2.setPassword("{noop}admin1");

        StudentGroup group1 = new StudentGroup();
        group1.setName("4I1");
        StudentGroup group2 = new StudentGroup();
        group2.setName("AiR");

        Quiz quiz = new Quiz();
        quiz.setName("Zaawansowany Machine Learning");
        quiz.setQuestions(questionlist1);
        quiz.setTeacher(teacher);
        quiz.setStudentGroup(group1);
        Quiz quiz2 = new Quiz();
        quiz2.setName("Bazy Danych");
        quiz2.setQuestions(questionlist2);
        quiz2.setTeacher(teacher2);
        quiz2.setStudentGroup(group2);
        Quiz quiz3 = new Quiz();
        quiz3.setName("Wstep do informatyki");
        quiz3.setQuestions(questionlist3);
        quiz3.setTeacher(teacher2);
        quiz3.setStudentGroup(group1);
        Quiz quiz4 = new Quiz();
        quiz4.setName("Analiza1");
        quiz4.setQuestions(questionlist4);
        quiz4.setTeacher(teacher);
        quiz4.setStudentGroup(group2);

        List<Quiz> list1 = Arrays.asList(quiz, quiz4);
        List<Quiz> list2 = Arrays.asList(quiz, quiz3);
        List<Quiz> list3 = Arrays.asList(quiz2, quiz3);
        List<Quiz> list4 = Arrays.asList(quiz2, quiz4);

        teacher.setQuizzes(list1);
        teacher2.setQuizzes(list3);


        Student student1 = new Student();
        student1.setId(1);
        student1.setName("Pawel_Nowak");
        student1.setPassword("{noop}12345");
        student1.setSolvedQuizzes(Collections.emptyList());
        student1.setGroup(group1);
        Student student2 = new Student();
        student2.setId(2);
        student2.setName("Antoni_Kot");
        student2.setPassword("{noop}haslo");
        student2.setSolvedQuizzes(Collections.emptyList());
        student2.setGroup(group2);

        group1.setQuizzes(list2);
        group2.setQuizzes(list4);
        group1.setStudents(Arrays.asList(student1));
        group2.setStudents(Arrays.asList(student2));


        this.teacherService.addTeacher(teacher);
        this.teacherService.addTeacher(teacher2);
        this.groupService.addGroup(group1);
        this.groupService.addGroup(group2);
        this.studentService.addStudent(student1);
        this.studentService.addStudent(student2);
        this.questionService.addQuestion(question1);
        this.questionService.addQuestion(question2);
        this.questionService.addQuestion(question3);
        this.questionService.addQuestion(question4);

        this.quizService.addQuiz(quiz);
        this.quizService.addQuiz(quiz2);
        this.quizService.addQuiz(quiz3);
        this.quizService.addQuiz(quiz4);



    }
}
