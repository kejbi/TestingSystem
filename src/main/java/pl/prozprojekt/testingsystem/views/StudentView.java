package pl.prozprojekt.testingsystem.views;

import pl.prozprojekt.testingsystem.views.UserView;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StudentView extends UserView {

    @NotNull
    private Long gruopId;

    private boolean isStudent = true;

    private String groupName;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

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
