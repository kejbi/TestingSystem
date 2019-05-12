package pl.prozprojekt.testingsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.prozprojekt.testingsystem.entities.Teacher;
import pl.prozprojekt.testingsystem.entities.User;
import pl.prozprojekt.testingsystem.repositories.TeacherRepo;


import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    private TeacherRepo teacherRepo;

    @Autowired
    public TeacherService(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    public Optional<Teacher> getTeacherById(Long id){
        return teacherRepo.findById(id);
    }

    public List<Teacher> getAllTeachers(){
        return teacherRepo.findAll();
    }

    public void addTeacher(Teacher teacher){
        teacherRepo.save(teacher);
    }

    public void deleteTeacherById(Long id){
        teacherRepo.deleteById(id);
    }
}
