package pl.prozprojekt.testingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import pl.prozprojekt.testingsystem.entities.Student;
import pl.prozprojekt.testingsystem.mappers.StudentMapper;
import pl.prozprojekt.testingsystem.services.StudentService;
import pl.prozprojekt.testingsystem.views.StudentView;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
@Secured("ROLE_USER")
public class StudentController {

    private StudentService studentService;
    private StudentMapper studentMapper;

    @Autowired
    public StudentController(StudentService studentService, StudentMapper studentMapper) {
        this.studentService = studentService;
        this.studentMapper = studentMapper;
    }

    @GetMapping("/{id}")
    public StudentView getStudentById(@PathVariable Long id){
        Student student = studentService.getStudentById(id).orElseThrow(EntityNotFoundException::new);
        return studentMapper.convertToView(student);
    }

    @GetMapping(params = "name")
    public StudentView getStudentByName(@RequestParam String name){
        Student student = studentService.getStudentByName(name).orElseThrow(EntityNotFoundException::new);
        return studentMapper.convertToView(student);
    }

    @GetMapping
    public List<StudentView> getAllStudents(){
        return studentService.getAllStudents().stream().map(student->studentMapper.convertToView(student)).collect(Collectors.toList());
    }

    @PostMapping
    public void addStudent(@RequestBody @Valid Student student, BindingResult bidingResult){
        if(bidingResult.hasErrors()){
            throw new ValidationException();
        }
        studentService.addStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id){
        studentService.deleteStudentById(id);
    }
}
