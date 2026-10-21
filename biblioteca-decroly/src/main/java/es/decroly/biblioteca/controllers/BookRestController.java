package es.decroly.biblioteca.controllers;

import es.decroly.biblioteca.domain.Book;
import es.decroly.biblioteca.service.Book.BookService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id){
        return bookService.listBookById(id);
    }

    @GetMapping("/{available}")
    public List<Book> getBooksEnable(){
        return bookService.enableBooks();
    }
}
