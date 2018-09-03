package net.joaolourenco.blog.authentication.controllers;

import net.joaolourenco.blog.authentication.service.impl.TestingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class TesterController {

    private static Logger log = LoggerFactory.getLogger(TesterController.class);

    @Autowired
    TestingService testingService;

    @GetMapping("/testing")
    boolean yei(@RequestParam("a") final String instrument) {
        log.info("Calling: " + instrument);
        testingService.set(instrument);
        return true;
    }

    @GetMapping("/testing2")
    boolean yei2(@RequestParam("a") final String instrument) {
        log.info("Calling: " + instrument);
        testingService.get(instrument);
        return true;
    }

    @GetMapping("/clear")
    boolean clear() {
        log.info("Clearing");
        testingService.clearCache();
        return true;
    }

}