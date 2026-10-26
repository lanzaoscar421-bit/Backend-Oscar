package es.decroly.biblioteca.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "library")
public record LibraryProperties(
        String nombre,
        int maxPrestamos,
        int diasPrestamo

) {

}
