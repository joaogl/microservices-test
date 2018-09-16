package net.joaolourenco.common.cache.impl;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import net.joaolourenco.common.domain.authentication.UserCachedDTO;
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
    public UserCachedDTO getAuthenticatedUser(String token) {
        return getSessionsMap().get(token);
    }

    @Override
    public Long activeAuthentications() {
        return new Long(getSessionsMap().size());
    }

    @Override
    public void storeAuthenticatedUser(Object key, UserCachedDTO userToCache) {
        ((IMap<String, UserCachedDTO>) getSessionsMap()).set(key.toString(), userToCache);
    }

    @Override
    public void invalidateUserAuthentication(Object key) {
        getSessionsMap().remove(key);
    }

    @CacheEvict(allEntries = true)
    @Override
    public void invalidateAllAuthentications() { }

    @Override
    public Map<String, UserCachedDTO> getSessionsMap() {
        return instance.getMap("sessions");
    }

}
