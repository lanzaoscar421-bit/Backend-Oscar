package com.Decroly.Mange_Bandas.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(new Info()
                .title("API Mange Bandas")
                .version("1.0")
                .description("Gestion de bandas")
                .contact(new Contact()
                        .name("Tu nombre")
                        .email("tu.correo@ejemplo.com")));
    }
}
