package net.joaolourenco.blog.gatewayservice.controllers;

import net.joaolourenco.blog.utils.AvailableServices;
import net.joaolourenco.blog.utils.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("accounts")
public class AccountsController extends BaseController {

    @GetMapping
    public ResponseEntity<String> check() {
        return ResponseEntity.ok(restTemplate.getForObject(getServiceURL(AvailableServices.AccountsService, "accounts"), String.class));
    }

}
