package pl.prozprojekt.testingsystem.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class QuizCreateRequest {

    @NotNull
    private Long groupId;

    @NotBlank
    private String name;

    @NotNull
    private Long teacherId;

    @NotNull
    private List<Long> questions;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Long> questions) {
        this.questions = questions;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }
}
