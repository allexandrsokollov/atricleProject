package com.sokolov.atricleproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.sokolov")
public class AtricleProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(AtricleProjectApplication.class, args);
    }

}
