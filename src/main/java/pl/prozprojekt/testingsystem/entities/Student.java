package pl.prozprojekt.testingsystem.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student extends User {

    @OneToMany(mappedBy = "student")
    private List<SolvedQuiz> solvedQuizzes;

    @ManyToOne
    private StudentGroup studentGroup;

    public List<SolvedQuiz> getSolvedQuizzes() {
        return solvedQuizzes;
    }

    public void setSolvedQuizzes(List<SolvedQuiz> solvedQuizzes) {
        this.solvedQuizzes = solvedQuizzes;
    }

    public StudentGroup getGroup() {
        return studentGroup;
    }

    public void setGroup(StudentGroup group) {
        this.studentGroup = group;
    }
}
