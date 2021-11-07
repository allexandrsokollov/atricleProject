package com.sokolov.articleproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@SpringBootApplication
public class ArticleProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArticleProjectApplication.class, args);
    }


    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.h2database");
        dataSource.setUrl("jdbc:h2:mem:default");
        dataSource.setUsername("asd");
        dataSource.setPassword("yfchbufdyjv");

        return dataSource;
    }
    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }



}