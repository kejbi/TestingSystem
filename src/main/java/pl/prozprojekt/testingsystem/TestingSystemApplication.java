package pl.prozprojekt.testingsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import pl.prozprojekt.testingsystem.services.StudentService;

@SpringBootApplication
public class TestingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestingSystemApplication.class, args);
    }



}
