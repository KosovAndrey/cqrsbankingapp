package com.kosovandrey.eventhandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.kosovandrey.*")
@ComponentScan(basePackages = "com.kosovandrey")
@EntityScan(basePackages = "com.kosovandrey")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
