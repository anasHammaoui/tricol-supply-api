package com.exemple.myapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter;

import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.exemple.myapp.controller")
public class WebConfig implements WebMvcConfigurer {
    @Bean
    public SimpleUrlHandlerMapping urlHandlerMapping() {
        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        Properties mappings = new Properties();
        mappings.put("/v1/suppliers", "supplierController");
        mappings.put("/v1/suppliers/*", "supplierController");
        mapping.setMappings(mappings);
        return mapping;
    }

    @Bean
    public SimpleControllerHandlerAdapter handlerAdapter() {
        return new SimpleControllerHandlerAdapter();
    }
}
