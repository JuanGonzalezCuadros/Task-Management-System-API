package com.example.Task_Management_System_API.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI taskManagementOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Task Management System API")
                        .description("API documentation for managing users and tasks")
                        .version("v1.0"));
    }
}
