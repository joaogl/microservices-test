package net.joaolourenco.blog.authentication.controllers;

import net.joaolourenco.blog.authentication.model.JwtUser;
import net.joaolourenco.blog.authentication.security.JwtGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    @Autowired
    private JwtGenerator jwtGenerator;

    @PostMapping("/{username}")
    public ResponseEntity<String> generate(@RequestBody final JwtUser jwtUser) {
        return ResponseEntity.ok(jwtGenerator.generate(jwtUser));
    }

}
