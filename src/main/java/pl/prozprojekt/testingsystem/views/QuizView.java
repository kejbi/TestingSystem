package pl.prozprojekt.testingsystem.views;

import javax.validation.constraints.NotNull;

public class QuizView {
    @NotNull
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
