package com.kosovandrey.cqrsbankingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class CqrsbankingappApplication {

    public static void main(String[] args) {
        SpringApplication.run(CqrsbankingappApplication.class, args);
    }

}
