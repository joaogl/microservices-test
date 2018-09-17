package net.joaolourenco.blog.gateway.controllers;

import net.joaolourenco.blog.common.AvailableServices;
import net.joaolourenco.blog.common.BaseController;
import net.joaolourenco.blog.common.domain.authentication.UserCredentialsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController extends BaseController {

    private static Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @PostMapping("/login")
    ResponseEntity<Boolean> login(@RequestBody() final UserCredentialsDTO user) {
        LOGGER.info("Attempting to login user: " + user.getUsername());

        String urlEndpoint = getServiceURL(AvailableServices.AuthenticationService, "auth/login");

        Boolean loginResponse = restTemplate.postForObject(urlEndpoint, user, Boolean.class);

        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/register")
    ResponseEntity<Long> register(@RequestBody() final UserCredentialsDTO user) {
        LOGGER.info("Attempting to register new user user: " + user.getUsername());

        String urlEndpoint = getServiceURL(AvailableServices.AuthenticationService, "auth/register");

        Long userId = restTemplate.postForObject(urlEndpoint, user, Long.class);

        return ResponseEntity.ok(userId);
    }

}