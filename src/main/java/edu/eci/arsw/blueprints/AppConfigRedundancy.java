package edu.eci.arsw.blueprints;

import edu.eci.arsw.blueprints.filters.impl.RedundancyFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import edu.eci.arsw.blueprints.filters.*;
import edu.eci.arsw.blueprints.persistence.impl.InMemoryBlueprintPersistence;
import edu.eci.arsw.blueprints.services.BlueprintsServices;

import java.util.logging.Filter;

@Configuration
public class AppConfigRedundancy {

    @Bean
    public InMemoryBlueprintPersistence inMemoryBlueprintPersistence() {
        return new InMemoryBlueprintPersistence();
    }

    @Bean
    public Filter redundancyFilter() {
        return (Filter) new RedundancyFilter();
    }

    @Bean
    public BlueprintsServices blueprintServices() {
        return new BlueprintsServices();
    }
}
