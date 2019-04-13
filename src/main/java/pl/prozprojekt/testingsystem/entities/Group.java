package pl.prozprojekt.testingsystem.entities;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long teacherId;

    private List<Student> students = new ArrayList<Student>();

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getTeacherId() { return teacherId; }

    public void setTeacherId(Long teacherId) { this.teacherId = teacherId; }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
