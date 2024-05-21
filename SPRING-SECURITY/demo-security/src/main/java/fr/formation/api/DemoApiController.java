package fr.formation.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")
public class DemoApiController {
    @GetMapping
    public String demo() {
        return "Hello world!";
    }
}
