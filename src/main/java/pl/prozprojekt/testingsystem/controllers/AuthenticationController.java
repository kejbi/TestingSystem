package pl.prozprojekt.testingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.prozprojekt.testingsystem.payload.JwtAuthenticationResponse;
import pl.prozprojekt.testingsystem.payload.LoginRequest;
import pl.prozprojekt.testingsystem.security.JwtTokenProvider;

import javax.validation.Valid;

/*
DATABASE SCRIPT FOR TESTING:
insert into role values (1, 'ROLE_USER');
insert into student_group values (1);
insert into student values (1, 'arton', '{noop}1234', 1); {noop} jest specjalnym oznaczeniem
insert into student_roles values (1, 1);

JSON do uzyskania tokena:
{
	"username":"arton",
	"password":"1234"
}
 */

@RestController
@RequestMapping("/signin")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider tokenProvider;


    @PostMapping
    public ResponseEntity<?> authenticate(@RequestBody @Valid LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String generatedToken = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(generatedToken));
    }
}
