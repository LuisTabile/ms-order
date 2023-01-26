package com.ms.order.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CORSConfig implements WebMvcConfigurer {

    private static final String ALLOWED_ORIGIN = "https://editor.swagger.io";
    private static final String ALLOWED_METHODS = "GET, POST, PUT, PATCH, DELETE";

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(ALLOWED_ORIGIN)
                .allowedMethods(ALLOWED_METHODS);
    }
}
