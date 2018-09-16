package net.joaolourenco.blog.authentication.services.impl;

import net.joaolourenco.blog.authentication.repository.UserAuthenticationsRepository;
import net.joaolourenco.blog.authentication.services.api.IAuthenticationService;
import net.joaolourenco.blog.authentication.domain.UserAuthentication;
import net.joaolourenco.common.domain.authentication.UserCachedDTO;
import net.joaolourenco.common.cache.impl.AuthCacheService;
import net.joaolourenco.common.exceptions.LoginException;
import net.joaolourenco.common.exceptions.errors.LoginErrorContants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthenticationService implements IAuthenticationService {

    @Autowired
    AuthCacheService authCacheService;

    @Autowired
    UserAuthenticationsRepository userAuthenticationsRepository;

    @Autowired
    TokenService tokenService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Long register(String username, String password) {

        // Check if its unique in the DB

        // If so add it

        // Else reject it

        return null;
    }

    @Override
    public UserCachedDTO login(String username, String password) {

        // Go on to the db a validate the user and password
        UserAuthentication user = userAuthenticationsRepository.findOneByUsername(username);

        // Attempts to login, throws either ERR_LOGIN_INVALID_PASSWORD or ERR_LOGIN_USER_NOT_FOUND if failed.
        attemptLogin(user, username, password);

        // Its checked generate token and return it
        UserCachedDTO loggedInUser = generateSession(user.getId(), username);

        // Store in session cache the authenticated user
        authCacheService.storeAuthenticatedUser(user.getId().toString(), loggedInUser);

        return loggedInUser;
    }

    private UserCachedDTO generateSession(Long userId, String username) {
        Date expiration = tokenService.getExpiration();

        String token = tokenService.createToken(userId, "", expiration);

        return new UserCachedDTO(userId, username, token, expiration);
    }

    private Boolean attemptLogin(UserAuthentication user, String username, String password) {

        if (user == null) {
            throw new LoginException(LoginErrorContants.ERR_LOGIN_USER_NOT_FOUND);
        }

        // Throw in the mix salt for extra security
        boolean loginState = passwordEncoder.matches(user.getPassword(), password + user.getSalt());

        if (!loginState) {
            throw new LoginException(LoginErrorContants.ERR_LOGIN_INVALID_PASSWORD);
        }

        return loginState;
    }

    @Override
    public void logout(Long userId) {

        authCacheService.invalidateUserAuthentication(userId);

    }

    @Override
    public Boolean isValid(String token) {

        // Check validity and all that of the token

        return null;
    }

    @Override
    public void destroyAllActiveSessions() {
        this.authCacheService.invalidateAllAuthentications();
    }



}
