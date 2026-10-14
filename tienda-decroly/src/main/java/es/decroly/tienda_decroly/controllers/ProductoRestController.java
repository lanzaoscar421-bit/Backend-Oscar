package es.decroly.tienda_decroly.controllers;

import es.decroly.tienda_decroly.domain.Producto;
import es.decroly.tienda_decroly.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/productos")
public class ProductoRestController {


    private final ProductService productService;


    public ProductoRestController(ProductService productService) {
        this.productService = productService;

    }


    @PostMapping()
    public Producto crear(@RequestBody Producto producto) {

        Producto p = productService.crear(producto);

        return p;
//        return productService.crear(producto);

    }

    @GetMapping()
    public List<Producto> listar() {

        return productService.listar();

    }

    @GetMapping("/{id}")
    public Producto buscarPorId(@PathVariable Long id) {

        return productService.buscarPorId(id);
    }


    @PutMapping("/{id}")
    public Producto modificar(@PathVariable Long id, @RequestBody Producto datos) {

        return productService.modificar(id, datos);
    }


    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id) {

        productService.borrar(id);
    }


}

