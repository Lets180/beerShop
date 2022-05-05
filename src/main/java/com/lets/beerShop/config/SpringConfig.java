package com.lets.beerShop.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;

@Configuration
@ComponentScan("com.lets.beerShop")
public class SpringConfig {

    @Bean
    public DataSource dataSource(){
        //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/beershop","postgres","180180141")
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/beershop");
        dataSource.setUsername("postgres");
        dataSource.setPassword("180180141");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }
}
