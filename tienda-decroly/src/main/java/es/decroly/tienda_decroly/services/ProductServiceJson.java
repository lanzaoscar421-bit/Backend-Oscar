package es.decroly.tienda_decroly.services;

import es.decroly.tienda_decroly.domain.Producto;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@Service
@Primary
public class ProductServiceJson extends ProductServiceBase{


    public ProductServiceJson(ObjectMapper mapper) throws IOException {


        super(cargar(mapper));
    }

    private static List<Producto> cargar(ObjectMapper mapper) throws IOException {

        ClassPathResource fichero = new ClassPathResource("productos.json");



        try (InputStream input = fichero.getInputStream()) {
            return List.of(mapper.readValue(input, Producto[].class));
        }

    }
}
