package es.decroly.tienda_decroly.controllers;

import es.decroly.tienda_decroly.domain.Producto;
import es.decroly.tienda_decroly.exceptions.BadRequestException;
import es.decroly.tienda_decroly.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
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

        Producto prd = validate(producto.getNombre(),producto.getPrecio(),producto.getStock());

        return nuevo(prd);
    }

    public Producto findById(Long id) {
        for (Producto p : productos) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        throw  new NotFoundException("No existe el producto con el id: " + id);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {


        Producto producto = findById(id);

        productos.remove(producto);

//        Producto producto = getProductoId(id);
//        productos.remove(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable Long id, @RequestBody Producto producto) {


        Producto existe = findById(id);





        existe.setNombre(producto.getNombre());
        existe.setPrecio(producto.getPrecio());
        existe.setStock(producto.getStock());

        return ResponseEntity.ok(existe);


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

    public Producto validate(String nombre, double precio, int stock) {

        if (nombre == null || nombre.isBlank()) {
            throw new BadRequestException("EL nombre esta vacio");
        } else if (precio < 0) {
            throw new BadRequestException("Precio negativo");
        } else if (stock < 0) {
            throw new BadRequestException("Stock negativo");
        }

        return new Producto(null, nombre, precio, stock);

    }
}

