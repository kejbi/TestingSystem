package pl.prozprojekt.testingsystem.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Student extends User {
    //na razie do testow proste inty, potem będa to listy lub inne kolekcje
    private int tests;

    private int rozwiazane;

    public int getTests() {
        return tests;
    }

    public void setTests(int tests) {
        this.tests = tests;
    }

    public int getRozwiazane() {
        return rozwiazane;
    }

    public void setRozwiazane(int rozwiazane) {
        this.rozwiazane = rozwiazane;
    }
}
