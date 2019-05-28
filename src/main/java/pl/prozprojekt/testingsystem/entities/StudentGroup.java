package pl.prozprojekt.testingsystem.entities;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class StudentGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "studentGroup")
    private List<Quiz> quizzes;

    @OneToMany(mappedBy = "studentGroup")
    private List<Student> students;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }
}
