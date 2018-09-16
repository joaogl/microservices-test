package net.joaolourenco.common.cache.api;

import net.joaolourenco.common.domain.authentication.UserCachedDTO;

import java.util.Map;

import static java.util.Objects.requireNonNull;

public interface AuthCache {

    UserCachedDTO getAuthenticatedUser(String token);

    Long activeAuthentications();

    void storeAuthenticatedUser(Object key, UserCachedDTO userToCache);

    void invalidateUserAuthentication(Object key);

    void invalidateAllAuthentications();

    Map<String, UserCachedDTO> getSessionsMap();

}