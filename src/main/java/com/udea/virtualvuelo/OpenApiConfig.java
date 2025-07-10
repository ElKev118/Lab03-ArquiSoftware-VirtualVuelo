package com.udea.virtualvuelo;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Api Gestion de Vuelos")
                        .version("1.0.0")
                        .description("API para la gestion de vuelos, incluyendo operaciones CRUD y funcionalidades de calificación de vuelos."));
    }
}