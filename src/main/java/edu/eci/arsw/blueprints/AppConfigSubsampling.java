package edu.eci.arsw.blueprints;

import edu.eci.arsw.blueprints.filters.impl.SubsamplingFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import edu.eci.arsw.blueprints.filters.*;
import edu.eci.arsw.blueprints.persistence.impl.InMemoryBlueprintPersistence;
import edu.eci.arsw.blueprints.services.BlueprintsServices;

import java.util.logging.Filter;

@Configuration
public class AppConfigSubsampling {

    @Bean
    public InMemoryBlueprintPersistence inMemoryBlueprintPersistence() {
        return new InMemoryBlueprintPersistence();
    }

    @Bean
    public Filter subsamplingFilter() {
        return (Filter) new SubsamplingFilter();
    }

    @Bean
    public BlueprintsServices blueprintServices() {
        return new BlueprintsServices();
    }
}
