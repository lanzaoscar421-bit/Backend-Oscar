package es.decroly.tienda_decroly.controllers;

import es.decroly.tienda_decroly.domain.Producto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ProductoRestController {

    //Datos provisiionales
    private final List<Producto> productos =  new ArrayList<>();

    private final AtomicLong secuencia = new AtomicLong();

    public ProductoRestController() {

        anadir("Teclado Mecanico", 30, 67);
        anadir("Libro de literatura Feminista", 10, 100);
        anadir("Tampones", 0, 100);
    }

    private void anadir(String nombre, double precio,int stock) {

        long id = secuencia.incrementAndGet();

        productos.add(new Producto(id,nombre,precio,stock));
    }



    //Ver toda la lista de productos
    @GetMapping("/api/productos")
    public List<Producto> getProductos() {
        return productos;
    }


    //Filtrar por ID
    @GetMapping("/api/productos/{id}")
    public Producto getProductoId(@PathVariable long id) {
        return productos.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

}