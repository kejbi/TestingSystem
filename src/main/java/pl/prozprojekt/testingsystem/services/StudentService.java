package pl.prozprojekt.testingsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.prozprojekt.testingsystem.entities.Student;
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

    public Optional<Student> getStudentById(Long id){
        return studentRepo.findById(id);
    }

    public Optional<Student> getStudentByName(String name){
        return studentRepo.findStudentByName(name);
    }

    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }

    public void addStudent(Student student){
        studentRepo.save(student);
    }

    public void deleteStudentById(Long id){
        studentRepo.deleteById(id);
    }
}
