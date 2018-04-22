package com.arydz.learning.analyzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
@ComponentScan("com.arydz.learning.analyzer")
public class BigDataAnalyzerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BigDataAnalyzerApplication.class, args);
    }
}
