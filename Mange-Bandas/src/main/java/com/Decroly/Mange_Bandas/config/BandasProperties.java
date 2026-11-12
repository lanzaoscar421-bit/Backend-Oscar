package com.Decroly.Mange_Bandas.config;
import org.springframework.boot.context.properties.ConfigurationProperties;

//http://localhost:8080/v3/api-docs
//http://localhost:8080/swagger-ui/index.html
@ConfigurationProperties(prefix = "bandas")
public record BandasProperties(String nombre, int maxBandas, int maxIntegrantes) {
}
