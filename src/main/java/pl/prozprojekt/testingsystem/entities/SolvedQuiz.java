package pl.prozprojekt.testingsystem.entities;

import javax.persistence.*;

@Entity
public class SolvedQuiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long answers;  //can be replaced later by string

    @ManyToOne
    private Student student;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAnswers() {
        return answers;
    }

    public void setAnswers(long answers) {
        this.answers = answers;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
