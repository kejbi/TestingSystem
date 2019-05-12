package pl.prozprojekt.testingsystem.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Teacher extends User {

    private int test; //put here so the entity wont be empty, almost certainly removed or changed but might be useful

    private int difficulty; //difficulty of test, might be used later to pass to test generating function

    public int getTest() {
        return test;
    }

    public void setTest(int test) {
        this.test = test;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}
