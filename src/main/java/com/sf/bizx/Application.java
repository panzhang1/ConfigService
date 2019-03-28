package com.sf.bizx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * It can only scan the component under this package com.sf.bizx.*
 * @author i312127
 *
 */
@SpringBootApplication
@RefreshScope
//public class Application extends SpringBootServletInitializer{
public class Application {
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(Application.class);
//    }
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}