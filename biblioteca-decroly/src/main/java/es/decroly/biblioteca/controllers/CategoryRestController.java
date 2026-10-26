package es.decroly.biblioteca.controllers;

import es.decroly.biblioteca.domain.Category;
import es.decroly.biblioteca.service.Category.CategoryService;
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

    @GetMapping("")
    public List<Category> getCategories() {
        return categoryService.listCategory();
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable Long id) {

        return categoryService.listByID(id);
    }

    @PostMapping()
    public Category addCategory(@RequestBody Category cat) {
        return categoryService.addCategory(cat);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id,@RequestBody Category cat) {
        return categoryService.updateCategory(id,cat);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }



}
