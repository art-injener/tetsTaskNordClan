package ru.art.testTaskNordClan.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Implements of WebMvcConfigurer
 * Defines callback methods to customize the Java-based configuration for Spring MVC enabled via @EnableWebMvc.
 * @author Danilchenko Artem
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     * Configure simple automated controllers pre-configured with the response status code and/or
     * a view to render the response body.
     * @param registry - class for registration controllers
     */
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }

    /**
     * Add handlers to serve static resources such as images, js, and, css files from specific locations
     * under web application root, the classpath, and others.
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }
}