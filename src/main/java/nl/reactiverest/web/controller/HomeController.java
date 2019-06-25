package nl.reactiverest.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class HomeController {

    /**
     *  Example request: curl -H 'Authorization: 5fd04f25-de33-4912-b9a6-396c775e7e2c' http://localhost:8080/home
     */
    @GetMapping("/home")
    public ResponseEntity<String> helloWorld(){
        final String result = "<h1>Hello World!</h1>";
        return new ResponseEntity(result, HttpStatus.OK);
    }

}
