package pl.prozprojekt.testingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.prozprojekt.testingsystem.controllers.controllers.StudentView;
import pl.prozprojekt.testingsystem.entities.Student;
import pl.prozprojekt.testingsystem.mappers.StudentMapper;
import pl.prozprojekt.testingsystem.services.StudentService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public Student getStudentById(@PathVariable Long id){
        Student student = studentService.getStudentById(id).orElseThrow(EntityNotFoundException::new);
        return student;
    }

    @GetMapping("/")
    public Student getStudentByName(@RequestParam String name){
        Student student = studentService.getStudentByName(name).orElseThrow(EntityNotFoundException::new);
        return student;
    }

    @GetMapping("/")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping("/")
    public void addStudent(@RequestBody @Valid Student student, BindingResult bidingResult){
        if(bidingResult.hasErrors()){
            throw new ValidationException();
        }
        studentService.addStudent(student);
    }

    @DeleteMapping("/")
    public void deleteStudentById(@PathVariable Long id){
        studentService.deleteStudentById(id);
    }
}
