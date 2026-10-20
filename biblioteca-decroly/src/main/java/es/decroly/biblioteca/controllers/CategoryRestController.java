package es.decroly.biblioteca.controllers;

import es.decroly.biblioteca.domain.Category;
import es.decroly.biblioteca.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Tag(name = "Categoria", description = "Categoria de libros")
@RequiredArgsConstructor
@RestController
@RequestMapping("api/category")
public class CategoryRestController {




    private final CategoryService categoryService;



    @GetMapping("")
    public List<Category> getCategories() {
        return categoryService.listar();
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable Long id) {


        return categoryService.listarID(id);

    }




}
