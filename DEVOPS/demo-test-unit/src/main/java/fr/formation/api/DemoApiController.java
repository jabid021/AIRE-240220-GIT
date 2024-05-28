package fr.formation.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.api.response.DemoResponse;
import fr.formation.service.DemoService;

@RestController
@RequestMapping("/api/demo")
public class DemoApiController {
    private static final Logger log = LoggerFactory.getLogger(DemoApiController.class);

    @Autowired
    private DemoService service;

    @GetMapping
    public String helloDemo() {
        log.debug("J'affiche la démo");

        return this.service.demo();
    }

    @GetMapping("/json")
    public List<DemoResponse> helloDemoJson() {
        log.debug("Je charge la liste des démo");

        return this.service.demoJson();
    }
}
