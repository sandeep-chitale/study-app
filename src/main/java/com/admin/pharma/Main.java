package com.admin.pharma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by DELL on 11/29/2015.
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan

public class Main extends SpringBootServletInitializer {

    public static void main(final String[] args) {
        SpringApplication.run(Main.class, args);

    }

    @Override
    protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(Main.class);
    }
}
