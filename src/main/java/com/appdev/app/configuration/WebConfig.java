package com.appdev.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // Adjust this to the origins you want to allow
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Adjust as needed
                .allowedHeaders("*"); // Adjust as needed
    }
}
