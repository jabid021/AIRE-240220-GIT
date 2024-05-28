package fr.formation.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.api.response.DemoResponse;
import fr.formation.service.DemoService;

@RestController
@RequestMapping("/api/demo")
public class DemoApiController {
    @Autowired
    private DemoService service;

    @GetMapping
    public String helloDemo() {
        String variableQueJutilisePas = "";

        System.out.println("J'affiche la démo");

        return this.service.demo();
    }

    @GetMapping("/json")
    public List<DemoResponse> helloDemoJson() {
        System.out.println("Je charge la liste des démo");

        return this.service.demoJson();
    }

    private void pasTerrible(String a, String b, String c, String d, String e, String f, String g, String h) {
        
    }
}
