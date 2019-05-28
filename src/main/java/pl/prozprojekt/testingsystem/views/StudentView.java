package pl.prozprojekt.testingsystem.views;

import pl.prozprojekt.testingsystem.views.UserView;

import javax.validation.constraints.NotNull;

public class StudentView extends UserView {

    @NotNull
    private Long gruopId;

    public Long getGruopId() {
        return gruopId;
    }

    public void setGruopId(Long gruopId) {
        this.gruopId = gruopId;
    }
}
