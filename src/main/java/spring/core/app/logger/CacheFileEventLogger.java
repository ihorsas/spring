package spring.core.app.logger;

import spring.core.app.event.Event;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {
    private int cacheSize;
    private List<Event> cache;

    public CacheFileEventLogger(String filename) {
        super(filename);
    }

    public CacheFileEventLogger(String filename, int cacheSize) {
        super(filename);
        this.cacheSize = cacheSize;
    }

    public CacheFileEventLogger(String filename, int cacheSize, List<Event> cach) {
        super(filename);
        this.cacheSize = cacheSize;
        this.cache = cach;
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);

        if (cache.size() == cacheSize) {
            writeToFile();
            cache.clear();
        }
    }

    @PostConstruct
    @Override
    public void init() throws IOException {
        super.init();
        cache = new ArrayList<Event>();
    }

    @PreDestroy
    public void destroy() {
        if (!cache.isEmpty())
            writeToFile();

    }

    private void writeToFile() {
        for (Event e : cache) super.logEvent(e);
    }
}
