package pl.prozprojekt.testingsystem.views;

import pl.prozprojekt.testingsystem.views.UserView;

import javax.validation.constraints.NotNull;

public class StudentView extends UserView {

    @NotNull
    private Long gruopId;

    private boolean isStudent = true;

    public Long getGruopId() {
        return gruopId;
    }

    public void setGruopId(Long gruopId) {
        this.gruopId = gruopId;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }
}
