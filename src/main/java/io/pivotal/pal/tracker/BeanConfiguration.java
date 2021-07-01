package io.pivotal.pal.tracker;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@org.springframework.context.annotation.Configuration
public class BeanConfiguration {

    @Bean
    public TimeEntryRepository timeEntryRepository() {
        return new InMemoryTimeEntryRepository();
    }

    @Bean
    public DataSource dataSource() { return DataSourceBuilder.create().build(); }

}
