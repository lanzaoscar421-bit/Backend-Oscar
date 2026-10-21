package es.decroly.tienda_decroly.controllers;

import es.decroly.tienda_decroly.domain.Producto;
import es.decroly.tienda_decroly.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Productos", description = "Catalogo de Productos")
@RequiredArgsConstructor
@RestController
@RequestMapping("api/productos")
public class ProductoRestController {


    private final ProductService productService;


//    public ProductoRestController(ProductService productService) {
//        this.productService = productService;
//
//    }


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

    @Operation(summary = "Consultar el producto por su id")
    @ApiResponse(responseCode = "200", description = "Producto encontrado")
    @ApiResponse(responseCode = "404" , description = "no exsiste este producto",

            content = @Content(schema = @Schema(implementation = ProblemDetail.class)
        ))
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

