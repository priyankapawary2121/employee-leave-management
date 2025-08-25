package com.employee.leave.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Employee Leave Management API")
                        .version("1.0")
                        .description("APIs for managing employees, leaves, and approvals"));
    }

    //http://localhost:8080/swagger-ui/index.html
}