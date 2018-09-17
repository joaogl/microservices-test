package net.joaolourenco.blog.authentication.services.impl;

import net.joaolourenco.blog.authentication.domain.UserAuthentication;
import net.joaolourenco.blog.authentication.repositories.UserAuthenticationsRepository;
import net.joaolourenco.blog.authentication.services.api.IAuthenticationService;
import net.joaolourenco.blog.common.exceptions.errors.RegistrationErrorContants;
import net.joaolourenco.blog.common.exceptions.exceptions.LoginException;
import net.joaolourenco.blog.common.exceptions.errors.LoginErrorContants;
import net.joaolourenco.blog.common.exceptions.exceptions.RegistrationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements IAuthenticationService {

    @Autowired
    UserAuthenticationsRepository userAuthenticationsRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Long createCredentials(String username, String password) {

        // Check if its unique in the DB
        UserAuthentication user = userAuthenticationsRepository.findOneByUsername(username);
        // UserAuthentication user = null;

        if (user != null) {
            throw new RegistrationException(RegistrationErrorContants.ERR_REGISTRATION_USERNAME_IN_USE);
        }

        user = new UserAuthentication();

        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));

        user = userAuthenticationsRepository.save(user);

        return user.getId();
    }

    @Override
    public Boolean checkCredentials(String username, String password) {

        // Go on to the db a validate the user and password
        UserAuthentication user = userAuthenticationsRepository.findOneByUsername(username);

        // Attempts to login, throws either ERR_LOGIN_INVALID_PASSWORD or ERR_LOGIN_USER_NOT_FOUND if failed.
        attemptLogin(user, password);

        return true;
    }

    private Boolean attemptLogin(UserAuthentication user, String password) {

        if (user == null) {
            throw new LoginException(LoginErrorContants.ERR_LOGIN_USER_NOT_FOUND);
        }

        boolean loginState = passwordEncoder.matches(password, user.getPassword());

        if (!loginState) {
            throw new LoginException(LoginErrorContants.ERR_LOGIN_INVALID_PASSWORD);
        }

        return loginState;
    }

}