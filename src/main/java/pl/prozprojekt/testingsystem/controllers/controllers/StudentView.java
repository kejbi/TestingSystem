package pl.prozprojekt.testingsystem.controllers.controllers;

public class StudentView extends UserView {

    private Long gruopId;

    public Long getGruopId() {
        return gruopId;
    }

    public void setGruopId(Long gruopId) {
        this.gruopId = gruopId;
    }
}
