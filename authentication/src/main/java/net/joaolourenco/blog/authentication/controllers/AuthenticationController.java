package net.joaolourenco.blog.authentication.controllers;

import net.joaolourenco.blog.authentication.services.impl.AuthenticationService;
import net.joaolourenco.blog.common.domain.authentication.UserCredentialsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private static Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/register")
    ResponseEntity<Long> register(@RequestBody final UserCredentialsDTO user) {
        LOGGER.info("Creating a new registration for user: " + user.getUsername());

        return ResponseEntity.ok(authenticationService.createCredentials(user.getUsername(), user.getPassword()));
    }

    @PostMapping("/login")
    ResponseEntity<Boolean> login(@RequestBody() final UserCredentialsDTO user) throws Exception {
        LOGGER.info("Attempting to login user: " + user.getUsername());

        try {
            return ResponseEntity.ok(authenticationService.checkCredentials(user.getUsername(), user.getPassword()));
        } catch (Exception e) {
            throw new Exception("Hi!");
        }
    }

}