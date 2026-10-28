package es.decroly.biblioteca.controllers;

import es.decroly.biblioteca.domain.Category;
import es.decroly.biblioteca.service.Category.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "Categoria", description = "Categoria de libros")
@RequiredArgsConstructor
@RestController
@RequestMapping("api/categoria")
public class CategoryRestController {

    private final CategoryService categoryService;

    @Operation(summary = "Lista las categorias")
    @ApiResponse(responseCode = "200", description = "Lista devuelta")
    @GetMapping("")
    public List<Category> getCategories() {
        return categoryService.listCategory();
    }

    @Operation(summary = "Obtiene una categoria por id")
    @ApiResponse(responseCode = "200", description = "Categoria encontrada")
    @ApiResponse(responseCode = "404", description = "No existe la categoria")
    @GetMapping("/{id}")
    public Category getCategory(@PathVariable Long id) {

        return categoryService.listByID(id);
    }

    @Operation(summary = "Crea una categoria")
    @ApiResponse(responseCode = "201", description = "Categoria creada")
    @ApiResponse(responseCode = "400", description = "Datos no validos")
    @ApiResponse(responseCode = "409", description = "Nombre repetido")
    @PostMapping()
    public Category addCategory(@RequestBody Category cat) {
        return categoryService.addCategory(cat);
    }

    @Operation(summary = "Modifica una categoria")
    @ApiResponse(responseCode = "200", description = "Categoria modificada")
    @ApiResponse(responseCode = "400", description = "Datos no validos")
    @ApiResponse(responseCode = "404", description = "No existe la categoria")
    @ApiResponse(responseCode = "409", description = "Nombre repetido")
    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id,@RequestBody Category cat) {
        return categoryService.updateCategory(id,cat);
    }

    @Operation(summary = "Borra una categoria")
    @ApiResponse(responseCode = "204", description = "Categoria borrada")
    @ApiResponse(responseCode = "404", description = "No existe la categoria")
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }



}