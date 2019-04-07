package pl.prozprojekt.testingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pl.prozprojekt.testingsystem.entities.Teacher;
import pl.prozprojekt.testingsystem.services.TeacherService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public Optional<Teacher> getTeacherById(@RequestParam Long id){
        return teacherService.getTeacherById(id);
    }

    @GetMapping("/all")
    public List<Teacher> getAllTeachers(){
        return teacherService.getAllTeachers();
    }

    @PostMapping
    public void addTeacher(@RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
    }

    @DeleteMapping
    public void deleteTeacherById(@RequestParam Long id){
        teacherService.deleteTeacherById(id);
    }
}