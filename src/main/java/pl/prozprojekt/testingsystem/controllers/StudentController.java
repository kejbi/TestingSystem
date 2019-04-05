package pl.prozprojekt.testingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.prozprojekt.testingsystem.entities.User;
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
    public Optional<User> getUserById(@RequestParam Long id){
        return studentService.getUserById(id);
    }

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return studentService.getAllUsers();
    }

    @PostMapping
    public void addUser(@RequestBody User user){
        studentService.addUser(user);
    }

    @DeleteMapping
    public void deleteUserById(@RequestParam Long id){
        studentService.deleteUserById(id);
    }
}
