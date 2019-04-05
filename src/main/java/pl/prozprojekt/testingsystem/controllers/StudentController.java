package pl.prozprojekt.testingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.prozprojekt.testingsystem.entities.Student;
import pl.prozprojekt.testingsystem.services.StudentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public Optional<Student> getStudentById(@RequestParam Long id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/all")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @DeleteMapping
    public void deleteStudentById(@RequestParam Long id){
        studentService.deleteStudentById(id);
    }
}
