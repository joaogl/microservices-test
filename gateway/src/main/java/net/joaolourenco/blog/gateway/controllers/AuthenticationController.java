package net.joaolourenco.blog.gateway.controllers;

import net.joaolourenco.blog.common.AvailableServices;
import net.joaolourenco.blog.common.BaseController;
import net.joaolourenco.blog.common.domain.authentication.UserCredentialsDTO;
import net.joaolourenco.blog.common.exceptions.errors.LoginErrorContants;
import net.joaolourenco.blog.common.exceptions.exceptions.LoginException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

@RestController
@RequestMapping("auth")
public class AuthenticationController extends BaseController {

    private static Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @PostMapping("/login")
    ResponseEntity<Boolean> login(@RequestBody() final UserCredentialsDTO user) {
        LOGGER.info("Attempting to login user: " + user.getUsername());

        try {
            return ResponseEntity.ok(restTemplate.postForObject(getServiceURL(AvailableServices.AuthenticationService, "auth/login"), user, Boolean.class));
        } catch (RestClientException e) {
            throw e;

            // throw new LoginException(LoginErrorContants.ERR_LOGIN_INVALID);
        }

    }

    @PostMapping("/register")
    ResponseEntity<Long> register(@RequestBody() final UserCredentialsDTO user) {
        LOGGER.info("Attempting to register new user user: " + user.getUsername());

        return ResponseEntity.ok(restTemplate.postForObject(getServiceURL(AvailableServices.AuthenticationService, "auth/register"), user, Long.class));
    }

}