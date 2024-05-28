package fr.formation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.formation.api.response.DemoResponse;

@Service
public class DemoService {
    public String demo() {
        return "Hello demo !!";
    }

    public List<DemoResponse> demoJson() {
        DemoResponse r1 = new DemoResponse();
        DemoResponse r2 = new DemoResponse();

        r1.setContent("R1");
        r2.setContent("R2");

        return List.of(r1, r2);
    }
}
