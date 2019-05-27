package pl.prozprojekt.testingsystem.views;

import javax.validation.constraints.NotNull;
import java.util.List;

public class SolvedQuizView {
    @NotNull
    private Long id;

    private List<Integer> answers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
