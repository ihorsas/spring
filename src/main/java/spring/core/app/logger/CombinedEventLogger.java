package spring.core.app.logger;

import spring.core.app.event.Event;

import java.util.ArrayList;
import java.util.List;

public class CombinedEventLogger implements EventLogger{
    private List<EventLogger> loggers;

    public CombinedEventLogger(List<EventLogger> loggers) {
        this.loggers = loggers;
    }

    public void init() {
        this.loggers = new ArrayList<EventLogger>();
    }

    public void logEvent(Event event) {
        for(EventLogger logger : loggers)
            logger.logEvent(event);
    }
}
