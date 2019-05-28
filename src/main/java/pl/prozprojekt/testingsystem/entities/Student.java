package pl.prozprojekt.testingsystem.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student extends User {

    @OneToMany(mappedBy = "student")
    private List<SolvedQuiz> solvedQuizzes;

    @ManyToOne
    @JoinColumn
    private StudentGroup studentGroup;

    public Student() {
        this.setStudent(true);
        setRole("ROLE_USER");
    }

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

    public StudentGroup getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
    }


}
