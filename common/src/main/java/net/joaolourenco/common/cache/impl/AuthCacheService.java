package net.joaolourenco.common.cache.impl;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import net.joaolourenco.common.authentication.models.UserCached;
import net.joaolourenco.common.cache.api.AuthCache;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@CacheConfig(cacheNames = "sessions")
public class AuthCacheService implements AuthCache {

    private HazelcastInstance instance;

    public AuthCacheService() {
        this.instance = Hazelcast.newHazelcastInstance();
    }

    @Override
    public UserCached getAuthenticatedUser(String token) {
        return getSessionsMap().get(token);
    }

    @Override
    public Long activeAuthentications() {
        return new Long(getSessionsMap().size());
    }

    @Override
    public void storeAuthenticatedUser(String key, UserCached userToCache) {
        ((IMap<String, UserCached>) getSessionsMap()).set(key, userToCache);
    }

    @Override
    public void invalidateUserAuthentication(String key) {
        getSessionsMap().remove(key);
    }

    @CacheEvict(allEntries = true)
    @Override
    public void invalidateAllAuthentications() { }

    @Override
    public Map<String, UserCached> getSessionsMap() {
        return instance.getMap("sessions");
    }

}
