package fr.formation.eventconsumer;

import java.util.function.Consumer;

import org.springframework.stereotype.Component;

@Component("onMessageDemo")
public class MessageDemoEventConsumer implements Consumer<String> {
    @Override
    public void accept(String evt) {
        System.out.println(evt);
    }
}
