package pl.prozprojekt.testingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.prozprojekt.testingsystem.entities.User;
import pl.prozprojekt.testingsystem.services.UserService;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Optional<User> getUserById(@RequestParam Long id){
        return userService.getUserById(id);
    }
}
