package com.springboot.section03springboothibernatejpacrud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Section03SpringBootHibernateJpaCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(Section03SpringBootHibernateJpaCrudApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return runner ->  {
            System.out.println("Hello World!");
        };
    }

}
