package spring.core.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.core.app.logger.CacheFileEventLogger;
import spring.core.app.logger.ConsoleEventLogger;
import spring.core.app.logger.EventLogger;
import spring.core.app.logger.FileEventLogger;

@Configuration
public class LoggersConfig {
    @Bean
    public EventLogger fileEventLogger(){
        return new FileEventLogger("output.txt");
    }
    @Bean
    public EventLogger cacheFileEventLogger(){
        return new CacheFileEventLogger("cacheOutput.txt");
    }
    @Bean
    public EventLogger consoleEventLogger(){
        return new ConsoleEventLogger();
    }
}
