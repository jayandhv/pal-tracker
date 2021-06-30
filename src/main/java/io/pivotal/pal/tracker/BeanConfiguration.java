package io.pivotal.pal.tracker;

import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class BeanConfiguration {

    @Bean
    public TimeEntryRepository timeEntryRepository() {
        return new InMemoryTimeEntryRepository();
    }

}
