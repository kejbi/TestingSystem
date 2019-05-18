package pl.prozprojekt.testingsystem.entities;

import javax.persistence.*;

@Entity
public class SolvedQuiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Student student;
}
