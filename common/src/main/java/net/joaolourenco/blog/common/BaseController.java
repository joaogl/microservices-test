package net.joaolourenco.blog.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public abstract class BaseController {

    @LoadBalanced
    @Bean
    public RestTemplate loadBalancedRestTemplate() {
        RestTemplate rest = new RestTemplate();

        rest.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        rest.getMessageConverters().add(new StringHttpMessageConverter());
        // rest.setErrorHandler(new ExceptionHanlder());

        return rest;
    }

    @Autowired
    public RestTemplate restTemplate;

    public String getServiceURL(AvailableServices service, String endpoint) {
        return "http://" + service.toString() + "/" + endpoint;
    }

    public URI getServiceURI(AvailableServices service, String endpoint) {
        return URI.create(this.getServiceURL(service, endpoint));
    }

}
