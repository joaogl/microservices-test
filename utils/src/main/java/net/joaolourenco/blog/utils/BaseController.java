package net.joaolourenco.blog.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public abstract class BaseController {

    @LoadBalanced
    @Bean
    public RestTemplate loadBalancedRestTemplate() {
        return new RestTemplate();
    }

    @Autowired
    public RestTemplate restTemplate;

    public String getServiceURL(AvailableServices service, String endpoint) {
        return "http://" + service.toString() + "/" + endpoint;
    }

}
