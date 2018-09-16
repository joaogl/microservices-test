package net.joaolourenco.blog.authentication.controllers;

import net.joaolourenco.blog.authentication.services.impl.AuthenticationService;
import net.joaolourenco.blog.authentication.domain.UserAuthentication;
import net.joaolourenco.common.domain.authentication.UserCachedDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private static Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/register")
    ResponseEntity<Long> register(@RequestBody final UserAuthentication user) {
        LOGGER.info("Creating a new registration for user: " + user.getUsername());

        Long newUserId = authenticationService.register(user.getUsername(), user.getPassword());

        return ResponseEntity.ok(newUserId);
    }

    @PostMapping("/login")
    ResponseEntity<UserCachedDTO> login(@RequestBody() final UserAuthentication user) {
        LOGGER.info("Attempting to login user: " + user.getUsername());

        return ResponseEntity.ok(authenticationService.login(user.getUsername(), user.getPassword()));
    }

    @PostMapping("/logout/{userId}")
    ResponseEntity logout(@RequestParam("userId") final Long userId) {
        LOGGER.info("Logging out user id: " + userId);

        authenticationService.logout(userId);

        return ResponseEntity.ok(null);
    }

    @GetMapping("/force-logout-all")
    ResponseEntity destroyAllActiveSessionsforceEveryoneToLogout() {
        LOGGER.info("Logging out every user with active sessions.");

        authenticationService.destroyAllActiveSessions();

        return ResponseEntity.ok(null);
    }

}