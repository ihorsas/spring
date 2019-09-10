package spring.core.app;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.core.app.logger.EventLogger;

public class App {
    private Client client;
    private EventLogger eventLogger;

    private App() {
    }

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public void logEvent(Event event) {
//        msg = msg.replaceAll(String.valueOf(client.getId()), client.getFullName());
        eventLogger.logEvent(event);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        App app = (App) context.getBean("app");
        app.client = new Client(1, "Igor Sas");

        app.logEvent((Event) context.getBean("event"));
        context.close();
    }
}
