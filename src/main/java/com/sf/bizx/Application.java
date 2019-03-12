package com.sf.bizx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
//public class Application extends SpringBootServletInitializer{
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);
    
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(Application.class);
//    }
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}