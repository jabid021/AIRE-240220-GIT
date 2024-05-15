package fr.formation.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.command.HelloKafkaCommand;

@RestController
@RequestMapping("/api/hello-kafka")
public class HelloKafkaApiController {
    @Autowired
    private StreamBridge streamBridge;

    @GetMapping
    public String hello() {
        HelloKafkaCommand command = new HelloKafkaCommand();

        command.setId("Un id");
        command.setMessage("Un message");

        this.streamBridge.send("hello-kafka", command);

        return "ok";
    }
}
