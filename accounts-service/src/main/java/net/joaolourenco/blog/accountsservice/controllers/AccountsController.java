package net.joaolourenco.blog.accountsservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("accounts")
public class AccountsController {

    @GetMapping
    public ResponseEntity<String> check(HttpServletRequest request) {
        return ResponseEntity.ok("hello world account");
    }

}
