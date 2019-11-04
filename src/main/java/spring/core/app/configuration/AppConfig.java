package spring.core.app.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({LoggersConfig.class, OtherConfig.class})
public class AppConfig {
}
