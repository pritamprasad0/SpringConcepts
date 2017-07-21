package com.pritamprasad.spring_intercepter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


/**
 * Configuration and Start class
 *
 */
@SpringBootApplication
public class SpringRestConfiguration extends SpringBootServletInitializer{
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringRestConfiguration.class);
    }
    
    public static void main(String[] args) {
	SpringApplication.run(SpringRestConfiguration.class, args);
    }

}
