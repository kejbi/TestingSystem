package pl.prozprojekt.testingsystem.entities;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class StudentGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
}
