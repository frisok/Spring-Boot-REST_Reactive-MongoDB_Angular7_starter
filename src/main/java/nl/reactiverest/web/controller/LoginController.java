package nl.reactiverest.web.controller;

import nl.reactiverest.data.UsernamePassword;
import nl.reactiverest.service.user.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 *
 */
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class LoginController {

    @Autowired
    private UserAuthenticationService authentication;

    /**
     * Example request: curl -H "Content-Type: application/json" -XPOST -d '{"username":"some_user_name","password":"some_password"}' http://localhost:8080/login
     */
    @PostMapping("/login")
    ResponseEntity<String> login(@RequestBody final UsernamePassword usernamePassword) {

        final Optional<String> result = authentication
                .login(usernamePassword.getUsername(), usernamePassword.getPassword());

        return new ResponseEntity(result, HttpStatus.OK);
    }

}