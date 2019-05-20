package pl.prozprojekt.testingsystem.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.prozprojekt.testingsystem.entities.User;
import pl.prozprojekt.testingsystem.repositories.StudentRepo;

/*
Used to get info about user after logging in from database
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    StudentRepo studentRepo; //only students for now

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = studentRepo.findStudentByName(username).orElseThrow(()-> new UsernameNotFoundException("User not found"));
        return CustomUserDetails.create(user);
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        User user = studentRepo.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found with id : " + id));
        return CustomUserDetails.create(user);
    }
}
