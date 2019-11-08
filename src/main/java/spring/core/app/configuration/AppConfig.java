package spring.core.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import spring.core.app.App;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Import({LoggersConfig.class, OtherConfig.class})
public class AppConfig {
    @Bean
    public App app() {
        return new App();
    }
}
