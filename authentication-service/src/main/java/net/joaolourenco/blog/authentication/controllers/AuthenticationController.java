package net.joaolourenco.blog.authentication.controllers;


import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import net.joaolourenco.blog.authentication.service.api.UserAuthenticationService;
import net.joaolourenco.blog.authentication.service.api.UserService;
import net.joaolourenco.common.authentication.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/authentication")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor(access = PACKAGE)
public class AuthenticationController {

    @NonNull
    UserAuthenticationService authentication;

    @NonNull
    UserService users;

    @PostMapping("/register")
    String register(
            @RequestParam("username") final String username,
            @RequestParam("password") final String password) {
        users
                .save(
                        User
                                .builder()
                                .id(username)
                                .username(username)
                                .password(password)
                                .build()
                );

        return login(username, password);
    }

    @PostMapping("/login")
    String login(
            @RequestParam("username") final String username,
            @RequestParam("password") final String password) {
        return authentication
                .login(username, password)
                .orElseThrow(() -> new RuntimeException("invalid login and/or password"));
    }

}
