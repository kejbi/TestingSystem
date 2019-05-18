package pl.prozprojekt.testingsystem.mappers;

import org.springframework.stereotype.Service;
import pl.prozprojekt.testingsystem.entities.Teacher;
import pl.prozprojekt.testingsystem.views.TeacherView;

@Service
public class TeacherMapper implements Mapper<Teacher, TeacherView> {
    public TeacherView convertToView(Teacher entity){
        TeacherView teacherView = new TeacherView();
        teacherView.setId(entity.getId());
        teacherView.setName(entity.getName());
        return teacherView;
    }

    public Teacher convertToEntity(TeacherView view){
        Teacher teacher = new Teacher();
        teacher.setId(view.getId());
        teacher.setName(view.getName());
        return teacher;
    }
}
