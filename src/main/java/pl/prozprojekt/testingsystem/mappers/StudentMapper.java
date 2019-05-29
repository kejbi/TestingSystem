package pl.prozprojekt.testingsystem.mappers;

import org.springframework.stereotype.Component;
import pl.prozprojekt.testingsystem.views.StudentView;
import pl.prozprojekt.testingsystem.entities.Student;

@Component
public class StudentMapper implements Mapper<Student, StudentView> {
    @Override
    public StudentView convertToView(Student student) {
        StudentView studentView = new StudentView();

        studentView.setId(student.getId());
        studentView.setName(student.getName());
        studentView.setGruopId(student.getGroup().getId());
        studentView.setGroupName(student.getGroup().getName());

        return studentView;
    }

    @Override
    public Student convertToEntity(StudentView studentView) {
        Student student = new Student();

        student.setId(studentView.getId());
        student.setName(studentView.getName());

        return student;
    }
}
