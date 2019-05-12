package pl.prozprojekt.testingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.prozprojekt.testingsystem.controllers.views.StudentView;
import pl.prozprojekt.testingsystem.entities.Student;
import pl.prozprojekt.testingsystem.mappers.StudentMapper;
import pl.prozprojekt.testingsystem.services.StudentService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    private StudentMapper studentMapper;

    @Autowired
    public StudentController(StudentService studentService, StudentMapper studentMapper) {
        this.studentService = studentService;
        this.studentMapper = studentMapper;
    }

    @GetMapping
    public StudentView getStudentById(@RequestParam Long id){
        Student student = studentService.getStudentById(id).orElseThrow(EntityNotFoundException::new);

        return studentMapper.convertToView(student);
    }

    @GetMapping
    public StudentView getStudentByName(@RequestParam String name){
        Student student = studentService.getStudentByName(name).orElseThrow(EntityNotFoundException::new);

        return studentMapper.convertToView(student);
    }

    @GetMapping("/all")
    public List<StudentView> getAllStudents(){
        return studentService.getAllStudents()
                .stream()
                .map(student -> studentMapper.convertToView(student))
                .collect(Collectors.toList());
    }

    @PostMapping
    public void addStudent(@RequestBody @Valid StudentView studentView, BindingResult bidingResult){
        if(bidingResult.hasErrors()){
            throw new ValidationException();
        }

        Student student = studentMapper.convertToEntity(studentView);
        studentService.addStudent(student);
    }

    @DeleteMapping
    public void deleteStudentById(@RequestParam Long id){
        studentService.deleteStudentById(id);
    }
}
