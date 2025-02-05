package com.kosovandrey.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = "com.kosovandrey")
@ComponentScan(basePackages = "com.kosovandrey")
@EnableJpaRepositories(basePackages = "com.kosovandrey.*")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
