package pl.prozprojekt.testingsystem.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.prozprojekt.testingsystem.entities.Teacher;
import pl.prozprojekt.testingsystem.entities.User;
import pl.prozprojekt.testingsystem.repositories.StudentRepo;
import pl.prozprojekt.testingsystem.repositories.TeacherRepo;

/*
Used to get info about user after logging in from database
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    StudentRepo studentRepo; //only students for now
    @Autowired
    TeacherRepo teacherRepo;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var userOptional = studentRepo.findStudentByName(username);
        User user;
        if(userOptional.isEmpty()){
            user = teacherRepo.findTeacherByName(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        }
        else{
            user = userOptional.get();
        }
        return CustomUserDetails.create(user);
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        User user = studentRepo.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found with id : " + id));
        return CustomUserDetails.create(user);
    }
}
