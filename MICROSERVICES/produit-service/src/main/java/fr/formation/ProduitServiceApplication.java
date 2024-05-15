package fr.formation;

import java.util.function.Consumer;
import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class ProduitServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProduitServiceApplication.class, args);
    }

    // @Bean
    // Consumer<String> onMessageDemo() {
    //     return evt -> {
    //         System.out.println(evt);
    //     };
    // }

    // @Bean
    // Function<String, String> onMessageDemoUpperCase() {
    //     return evt -> {
    //         System.out.println("UPPERCASE " + evt);

    //         return evt.toUpperCase();
    //     };
    // }
}
