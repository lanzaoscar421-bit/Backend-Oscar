package es.decroly.biblioteca.controllers;

import es.decroly.biblioteca.domain.Book;
import es.decroly.biblioteca.service.Book.BookService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Libro", description = "Libros")
@RequiredArgsConstructor
@RestController
@RequestMapping("api/book")
public class BookRestController {

    private final BookService bookService;


    @GetMapping("")
    public List<Book> getBooks(){
        return bookService.listBook();
    }
}
