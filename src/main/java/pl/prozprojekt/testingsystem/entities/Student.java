package pl.prozprojekt.testingsystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student extends User {

    @JsonIgnore
    @ManyToMany(mappedBy = "students")
    private List<Quiz> quizzes;

    @JsonIgnore
    @OneToMany(mappedBy = "student")
    private List<SolvedQuiz> solvedQuizzes;

    @ManyToOne
    @JoinColumn(name = "fk_student_group")
    private StudentGroup group;

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> guizzes) {
        this.quizzes = guizzes;
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
