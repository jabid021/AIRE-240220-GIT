package fr.formation.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.api.response.DemoResponse;

@RestController
@RequestMapping("/api/demo")
public class DemoApiController {
    @GetMapping
    public String helloDemo() {
        return "Hello demo !!";
    }

    @GetMapping("/json")
    public List<DemoResponse> helloDemoJson() {
        DemoResponse r1 = new DemoResponse();
        DemoResponse r2 = new DemoResponse();

        r1.setContent("R1");
        r2.setContent("R2");

        return List.of(r1, r2);
    }
}
