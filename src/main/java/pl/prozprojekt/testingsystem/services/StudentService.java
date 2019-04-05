package pl.prozprojekt.testingsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.prozprojekt.testingsystem.entities.User;
import pl.prozprojekt.testingsystem.repositories.StudentRepo;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Optional<User> getUserById(Long id){
        return studentRepo.findById(id);
    }

    public List<User> getAllUsers(){
        return studentRepo.findAll();
    }

    public void addUser(User user){
        studentRepo.save(user);
    }

    public void deleteUserById(Long id){
        studentRepo.deleteById(id);
    }
}
