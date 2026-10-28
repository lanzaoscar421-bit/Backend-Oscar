package es.decroly.biblioteca.controllers;

import es.decroly.biblioteca.domain.Book;
import es.decroly.biblioteca.service.Book.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Libro", description = "Libros")
@RequiredArgsConstructor
@RestController
@RequestMapping("api/libro")
public class BookRestController {


    private final BookService bookService;


    @Operation(summary = "Lista los libros")
    @ApiResponse(responseCode = "200", description = "Lista devuelta")
    @GetMapping("")
    public List<Book> getBooks(){
        return bookService.listBook();
    }

    @Operation(summary = "Obtiene un libro por id")
    @ApiResponse(responseCode = "200", description = "Libro encontrado")
    @ApiResponse(responseCode = "404", description = "No existe el libro")
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id){
        return bookService.listBookById(id);
    }

    //En este caso no se pone el {} Por que no se insertaran valores
    @Operation(summary = "Lista los libros con ejemplares disponibles")
    @ApiResponse(responseCode = "200", description = "Lista devuelta")
    @GetMapping("/available")
    public List<Book> getBooksEnable(){
        return bookService.enableBooks();
    }

    @Operation(summary = "Crea un libro")
    @ApiResponse(responseCode = "201", description = "Libro creado")
    @ApiResponse(responseCode = "400", description = "Datos no validos")
    @ApiResponse(responseCode = "409", description = "ISBN repetido")
    @PostMapping
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @Operation(summary = "Modifica un libro")
    @ApiResponse(responseCode = "200", description = "Libro modificado")
    @ApiResponse(responseCode = "400", description = "Datos no validos")
    @ApiResponse(responseCode = "404", description = "No existe el libro")
    @ApiResponse(responseCode = "409", description = "ISBN repetido")
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id,@RequestBody Book book){
        return bookService.updateBook(id,book);
    }

    @Operation(summary = "Borra un libro")
    @ApiResponse(responseCode = "204", description = "Libro borrado")
    @ApiResponse(responseCode = "404", description = "No existe el libro")
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
    }
}