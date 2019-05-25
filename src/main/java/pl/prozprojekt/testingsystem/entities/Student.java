package pl.prozprojekt.testingsystem.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student extends User {

    @ManyToMany(mappedBy = "students")
    private List<Quiz> quizzes;

    @OneToMany(mappedBy = "student")
    private List<SolvedQuiz> solvedQuizzes;

    @ManyToOne
    @JoinColumn(name = "fk_student_group")
    private StudentGroup group;

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    public List<SolvedQuiz> getSolvedQuizzes() {
        return solvedQuizzes;
    }

    public void setSolvedQuizzes(List<SolvedQuiz> solvedQuizzes) {
        this.solvedQuizzes = solvedQuizzes;
    }

    public StudentGroup getGroup() {
        return group;
    }

    public void setGroup(StudentGroup group) {
        this.group = group;
    }
}
