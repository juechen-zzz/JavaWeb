package com.komorebi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class Springboot10TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot10TestApplication.class, args);
    }

}
