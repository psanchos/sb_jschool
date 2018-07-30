package ru.sbrf.jschool.spring.jdbc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("ru.sbrf.jschool.spring.jdbc")
public class TestSpringConfig {

    @Bean
    public DataSource dataSource(){
        return new DriverManagerDataSource("jdbc:h2:mem:test;INIT=RUNSCRIPT FROM 'classpath:init.sql';DB_CLOSE_DELAY=-1");
    }
}
