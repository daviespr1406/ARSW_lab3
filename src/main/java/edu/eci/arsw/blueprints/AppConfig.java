package edu.eci.arsw.blueprints;

import edu.eci.arsw.blueprints.filters.BlueprintFilter;
import edu.eci.arsw.blueprints.filters.impl.RedundancyFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"edu.eci.arsw.blueprints"})
public class AppConfig {
    @Bean
    public BlueprintFilter blueprintFilter() {
        return new RedundancyFilter();
    }
}
