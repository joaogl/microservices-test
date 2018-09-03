package net.joaolourenco.blog.gatewayservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("authentication")
public class AuthenticationController {

    @GetMapping
    public ResponseEntity<String> check() {
        return ResponseEntity.ok("hello world main auth");
    }

}
