package pl.prozprojekt.testingsystem.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.prozprojekt.testingsystem.entities.Student;
import pl.prozprojekt.testingsystem.entities.User;
import pl.prozprojekt.testingsystem.repositories.StudentRepo;
import pl.prozprojekt.testingsystem.repositories.TeacherRepo;

import java.util.Optional;

/*
Used to get info about user after logging in from database
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    StudentRepo studentRepo;
    TeacherRepo teacherRepo;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<? extends User> user = studentRepo.findStudentByName(username);
        if(user.isEmpty())
            user = teacherRepo.findTeacherByName(username);
        return CustomUserDetails.create(user.orElseThrow(() -> new UsernameNotFoundException("User not found with name : " + username)));
    }

    @Transactional
    public UserDetails loadUserById(Long id, boolean isStudent) {
        User user;
        if(isStudent)
            user = studentRepo.findById(id).orElseThrow(() -> new UsernameNotFoundException("Student not found with id : " + id));
        else
            user = teacherRepo.findById(id).orElseThrow(() -> new UsernameNotFoundException("Teacher not found with id : " + id));
        return CustomUserDetails.create(user);
    }
}
