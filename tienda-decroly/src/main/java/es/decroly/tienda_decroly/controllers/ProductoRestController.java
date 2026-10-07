package es.decroly.tienda_decroly.controllers;

import es.decroly.tienda_decroly.domain.Producto;
import org.apache.coyote.http11.filters.IdentityInputFilter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.*;
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


    private ResponseEntity <Producto> nuevo(Producto producto) {

        long id = secuencia.incrementAndGet();

        Producto prd = new Producto(id,producto.getNombre(),producto.getPrecio(),producto.getStock());
        productos.add(prd);
        URI direccion = URI.create("/api/productos/"+id);
        return ResponseEntity.created(direccion).build();
    }


    //Ver toda la lista de productos
    @GetMapping()
    public ResponseEntity<List<Producto>>listar() {

        return ResponseEntity.ok(productos);
    }




    @PostMapping()
    public ResponseEntity<Producto> crear(@RequestBody Producto producto) {

        return nuevo(producto);
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
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        Iterator<Producto> it = productos.iterator();


        while (it.hasNext()) {
            Producto producto = it.next();
            if (producto.getId().equals(id)) {
                it.remove();
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.noContent().build();

//        Producto producto = getProductoId(id);
//        productos.remove(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable Long id, @RequestBody Producto producto) {


        Optional<Producto> existe = buscar(id);

        if (existe.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Producto prod = existe.get();


        prod.setNombre(producto.getNombre());
        prod.setPrecio(producto.getPrecio());
        prod.setStock(producto.getStock());

        return ResponseEntity.ok(prod);


//        Optional<Producto> existente = buscar(id);
//        if (existente.isEmpty()) {
//            return null;
//        }
//        producto.setNombre(producto.getNombre());
//        producto.setPrecio(producto.getPrecio());
//        producto.setStock(producto.getStock());
//        return producto;

    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarPorId(@PathVariable Long id) {


        for(Producto p : productos) {
            if(p.getId().equals(id)) {
                return ResponseEntity.ok(p);
            }
        }
        return ResponseEntity.notFound().build();//404
    }

}

