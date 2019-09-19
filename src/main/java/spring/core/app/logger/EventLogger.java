package spring.core.app.logger;

import spring.core.app.event.Event;

public interface EventLogger {
    void logEvent(Event event);
}
