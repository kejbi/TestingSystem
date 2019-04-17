package pl.prozprojekt.testingsystem.entities;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Transient
    private Teacher teacher;

    @Transient
    private List<Student> students;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Teacher getTeacher() { return teacher; }

    public void setTeacher(Teacher teacher) { this.teacher = teacher; }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
