package net.joaolourenco.blog.authentication.services.impl;

import net.joaolourenco.blog.authentication.services.api.Authentication;
import net.joaolourenco.common.authentication.models.UserCached;
import net.joaolourenco.common.cache.impl.AuthCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements Authentication {

    @Autowired
    AuthCacheService authCacheService;

    @Override
    public Long register(String username, String password) {

        // Check if its unique in the DB

        // If so add it

        // Else reject it

        return null;
    }

    @Override
    public UserCached login(String username, String password) {

        // Go on to the db a validate the user and password

        // If checked generate token and return it

        // Else Invalid

        return null;
    }

    @Override
    public void logout(Long userId) {

        // Go to hazelcast and delete this key

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
