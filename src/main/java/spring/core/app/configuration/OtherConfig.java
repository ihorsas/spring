package spring.core.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import spring.core.app.event.Event;

import java.text.DateFormat;
import java.util.Date;

@Configuration
public class OtherConfig {
    @Bean
    @Scope("prototype")
    public Event event() {
        return new Event(new Date(), DateFormat.getTimeInstance());
    }
}
