package es.decroly.tienda_decroly.controllers;

import es.decroly.tienda_decroly.domain.Producto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("api/productos")
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


    private Producto nuevo(Producto producto) {

        long id = secuencia.incrementAndGet();

        Producto prd = new Producto(id,producto.getNombre(),producto.getPrecio(),producto.getStock());
        productos.add(prd);
        return prd;
    }


    //Ver toda la lista de productos
    @GetMapping()
    public List<Producto> getProductos() {
        return productos;
    }


    //Filtrar por ID
    @GetMapping("/{id}")
    public Producto getProductoId(@PathVariable long id) {
        return productos.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }



    @PostMapping()
    public Producto crear(@RequestBody Producto producto) {

        return nuevo(producto);
    }




    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable Long id, @RequestBody Producto producto) {

        for(Producto p : productos) {
            if(p.getId().equals(id)) {
                p.setNombre(producto.getNombre());
                p.setPrecio(producto.getPrecio());
                p.setStock(producto.getStock());

                return p;
            }
        }

        return null;

//        Optional<Producto> existente = buscar(id);
//        if (existente.isEmpty()) {
//            return null;
//        }
//        producto.setNombre(producto.getNombre());
//        producto.setPrecio(producto.getPrecio());
//        producto.setStock(producto.getStock());
//        return producto;

        
    }
    public Optional<Producto> buscar(Long id) {
        for (Producto p : productos) {
            if (p.getId().equals(id)) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        productos.removeIf(p -> p.getId() == id);
//        Producto producto = getProductoId(id);
//        productos.remove(producto);
    }

}

