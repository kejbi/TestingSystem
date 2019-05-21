package pl.prozprojekt.testingsystem.mappers;

import org.springframework.stereotype.Component;
import pl.prozprojekt.testingsystem.entities.Teacher;
import pl.prozprojekt.testingsystem.views.TeacherView;

@Component
public class TeacherMapper implements Mapper<Teacher, TeacherView> {
    @Override
    public TeacherView convertToView(Teacher entity){
        TeacherView teacherView = new TeacherView();
        teacherView.setId(entity.getId());
        teacherView.setName(entity.getName());
        return teacherView;
    }

    @Override
    public Teacher convertToEntity(TeacherView view){
        Teacher teacher = new Teacher();
        teacher.setId(view.getId());
        teacher.setName(view.getName());
        return teacher;
    }
}
