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

    //En este caso no se pone el {} Por que no se insertaran valores
    @GetMapping("/available")
    public List<Book> getBooksEnable(){
        return bookService.enableBooks();
    }

    @PostMapping
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id,@RequestBody Book book){
        return bookService.updateBook(id,book);
    }
    
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
    }
}
