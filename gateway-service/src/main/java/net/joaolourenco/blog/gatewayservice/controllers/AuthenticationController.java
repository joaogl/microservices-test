package net.joaolourenco.blog.gatewayservice.controllers;

import net.joaolourenco.common.AvailableServices;
import net.joaolourenco.common.BaseController;
import net.joaolourenco.common.domain.authentication.UserAuthenticationDTO;
import net.joaolourenco.common.domain.authentication.UserCachedDTO;
import net.joaolourenco.common.exceptions.CommonException;
import net.joaolourenco.common.exceptions.LoginException;
import net.joaolourenco.common.exceptions.errors.LoginErrorContants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("authentication")
public class AuthenticationController extends BaseController {

    private static Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @PostMapping("/login")
    ResponseEntity<UserCachedDTO> login(@RequestBody() final UserAuthenticationDTO user) {
        LOGGER.info("Attempting to login user: " + user.getUsername());

        try {
            return ResponseEntity.ok(restTemplate.getForObject(getServiceURL(AvailableServices.AuthenticationService, "auth/login"), UserCachedDTO.class));
        } catch (LoginException e) {
            throw new LoginException(LoginErrorContants.ERR_LOGIN_INVALID);
        }

    }

}
