package net.joaolourenco.common.cache.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Value;
import net.joaolourenco.common.authentication.models.UserCached;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static java.util.Objects.requireNonNull;

public interface AuthCache {

    UserCached getAuthenticatedUser(String token);

    Long activeAuthentications();

    void storeAuthenticatedUser(String key, UserCached userToCache);

    void invalidateUserAuthentication(String key);

    void invalidateAllAuthentications();

    Map<String, UserCached> getSessionsMap();

}