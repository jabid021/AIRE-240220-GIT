package fr.formation.eventconsumer;

import java.util.function.Function;

import org.springframework.stereotype.Component;

@Component("onMessageDemoUpperCase")
public class MessageDemoUpperCaseEventFunction implements Function<String, String> {
    @Override
    public String apply(String evt) {
        return evt.toUpperCase();
    }
}
