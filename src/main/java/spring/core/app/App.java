package spring.core.app;

import spring.core.app.logger.ConsoleEventLogger;
import spring.core.app.logger.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private Client client;
    private EventLogger eventLogger;

    private App(){}

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public void logEvent(Event event){
//        msg = msg.replaceAll(String.valueOf(client.getId()), client.getFullName());
        eventLogger.logEvent(event);
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        App app = (App) context.getBean("app");
        app.client = new Client(1, "Igor Sas");
        app.eventLogger = new ConsoleEventLogger();

        app.logEvent((Event) context.getBean("event"));
    }
}
