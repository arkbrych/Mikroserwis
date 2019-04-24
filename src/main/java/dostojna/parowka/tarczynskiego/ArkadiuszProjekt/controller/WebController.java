package dostojna.parowka.tarczynskiego.ArkadiuszProjekt.controller;

import dostojna.parowka.tarczynskiego.ArkadiuszProjekt.app.Gender;
import dostojna.parowka.tarczynskiego.ArkadiuszProjekt.models.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.Instant;

/*
 * @Author: Arkadiusz Brych
 * @RestController indicates that this class will have Rest End points
 * */
@RestController
public class WebController {

    private static Logger logger = LoggerFactory.getLogger(WebController.class);

    // RequestMapping - how function should be run
    @RequestMapping(value = "/sample", method = RequestMethod.GET)
    public ResponseEntity<Person> Sample(@RequestParam(value = "name"
    ) String name, @RequestParam(value = "surname") String surname) throws IllegalArgumentException {

        // This class models a single instantaneous point on the time-line.
        // This might be used to record event time-stamps in the application
        Instant before = Instant.now();

        // A data structure representing HTTP request or response headers,
        // mapping String header names to a list of String values,
        // also offering accessors for common application-level data types.
        HttpHeaders responseHeaders = new HttpHeaders();
        if (name.equals("") || surname.equals("")) {
            throw new IllegalArgumentException("The name or surname parameter is empty");
        }

        Person person = new Person(name, surname, Gender.checkGender(name));

        Instant after = Instant.now();
        long delta = Duration.between(before, after).toMillis();

        responseHeaders.set("AppProcessingTime", Long.toString(delta));

        // Build ResponseEntity with status OK with headers and body
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(person);
    }

    @ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="The name and surname parameters can't be empty")
    // catching IllegalArgumentException in current class
    @ExceptionHandler(IllegalArgumentException.class)
    public void handleIllegalArgumentException(){
        logger.error("Empty parameters");
        //returning 400 error code
    }
}
