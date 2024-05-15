package fr.formation;

import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import fr.formation.eventconsumer.MessageDemoEventConsumer;

@SpringBootApplication
@EnableFeignClients
public class ProduitServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProduitServiceApplication.class, args);
    }


    public void example() {
        MessageDemoEventConsumer mdec = new MessageDemoEventConsumer();

        mdec.accept("null");

        Consumer<String> csm = new Consumer<String>() {
            @Override
            public void accept(String evt) {
                System.out.println(evt);
            }
        };
        
        csm.accept("null");

        Consumer<String> csm2 = evt -> {
            System.out.println(evt);
        };

        csm2.accept("null");
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
