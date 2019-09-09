package spring.core.app.logger;

import spring.core.app.Event;

public class ConsoleEventLogger implements EventLogger{

    public void logEvent(Event event) {
        System.out.println(event);
    }
}
