package net.joaolourenco.blog.gatewayservice.controllers;

import net.joaolourenco.common.AvailableServices;
import net.joaolourenco.common.BaseController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("accounts")
public class AccountsController extends BaseController {

    @GetMapping
    public ResponseEntity<String> check() {
        return ResponseEntity.ok(restTemplate.getForObject(getServiceURL(AvailableServices.AccountsService, "accounts"), String.class));
    }

}
