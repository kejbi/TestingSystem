package pl.prozprojekt.testingsystem.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.*;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Teacher extends User {
    @OneToMany(mappedBy = "teacher")
    private List<Quiz> quizzes;

    public Teacher() {
        setRole("ROLE_TEACHER");
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }
}

