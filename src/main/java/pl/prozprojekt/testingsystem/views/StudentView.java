package pl.prozprojekt.testingsystem.views;

import pl.prozprojekt.testingsystem.views.UserView;

public class StudentView extends UserView {

    private Long gruopId;

    public Long getGruopId() {
        return gruopId;
    }

    public void setGruopId(Long gruopId) {
        this.gruopId = gruopId;
    }
}
