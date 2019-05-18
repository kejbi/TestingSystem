package pl.prozprojekt.testingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import pl.prozprojekt.testingsystem.entities.Teacher;
import pl.prozprojekt.testingsystem.mappers.TeacherMapper;
import pl.prozprojekt.testingsystem.services.TeacherService;
import pl.prozprojekt.testingsystem.views.TeacherView;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private TeacherService teacherService;
    private TeacherMapper teacherMapper;

    @Autowired
    public TeacherController(TeacherService teacherService, TeacherMapper teacherMapper) {
        this.teacherService = teacherService;
        this.teacherMapper = teacherMapper;
    }

    @GetMapping("/{id}")
    public TeacherView getStudentById(@PathVariable Long id){
        Teacher teacher = teacherService.getTeacherById(id).orElseThrow(EntityNotFoundException::new);
        return teacherMapper.convertToView(teacher);
    }

    @GetMapping(params = "name")
    public TeacherView getStudentByName(@RequestParam String name){
        Teacher teacher = teacherService.getTeacherByName(name).orElseThrow(EntityNotFoundException::new);
        return teacherMapper.convertToView(teacher);
    }

    @GetMapping
    public List<TeacherView> getAllTeachers(){
        return teacherService.getAllTeachers().stream().map(teacher->teacherMapper.convertToView(teacher)).collect(Collectors.toList());
    }

    @PostMapping
    public void addTeacher(@RequestBody @Valid Teacher teacher, BindingResult bidingResult){
        if(bidingResult.hasErrors()){
            throw new ValidationException();
        }
        teacherService.addTeacher(teacher);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id){
        teacherService.deleteTeacherById(id);
    }
}