package spring.core.app;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.core.app.event.Event;
import spring.core.app.event.EventType;
import spring.core.app.logger.*;

import java.util.HashMap;
import java.util.Map;

public class App {
    private Client client;
    private Map<EventType, EventLogger> loggers;
    private EventLogger eventLogger;

    private App() {
    }
    //TODO: should be Map<EventType, List<EventLogger>>
    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.eventLogger = eventLogger;
        this.loggers = loggers;
    }

    public void logEvent(EventType type, Event event) {
        EventLogger logger = loggers.get(type);
        if(logger == null)
            logger = eventLogger;
        logger.logEvent(event);
    }

    public void init(){
        loggers = new HashMap<EventType, EventLogger>();
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        App app = (App) context.getBean("app");
        Event event = (Event) context.getBean("event");
        event.setId(app.client.getId());
        event.setMessage(app.client.getGreeting());
        app.logEvent(EventType.INFO, event);
        context.close();
    }
}
