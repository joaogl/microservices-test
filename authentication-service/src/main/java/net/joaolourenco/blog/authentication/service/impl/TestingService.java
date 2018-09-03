package net.joaolourenco.blog.authentication.service.impl;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@CacheConfig(cacheNames = "instruments")
public class TestingService {

    @Autowired
    private HazelcastInstance instance;

    private static Logger log = LoggerFactory.getLogger(TestingService.class);

    @CacheEvict(allEntries = true)
    public void clearCache(){
//         instance.get
    }

    // @Cacheable
    public String set(String instrument) {
        java.util.Map<String,String> stringStringMap = instance.getMap("instruments");

        ((IMap<String, String>) stringStringMap).set(instrument, "Yello");

        log.info("Setting: " + instrument);
        return "paying " + instrument + "!";
    }

    // @Cacheable
    public String get(String instrument) {
        java.util.Map<String,String> stringStringMap = instance.getMap("instruments");

        log.info("Getting: " + stringStringMap.get(instrument));
        return "paying " + instrument + "!";
    }

}