package com.github.alexescg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author alex
 */
@EnableAutoConfiguration
@ComponentScan({"com.github.alexescg.component"})
public class SpringSystemInfoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringSystemInfoApplication.class, args);
    }
}

