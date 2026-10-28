package es.decroly.biblioteca.service.Book;

import es.decroly.biblioteca.domain.Book;
import es.decroly.biblioteca.exceptions.NotFoundException;
import es.decroly.biblioteca.exceptions.ValidateException;

import java.util.List;

public interface BookService {

    /**
     * Lista todos los libros.
     *
     * @return todos los libros
     */
    List<Book> listBook();

    /**
     * Busca un libro por id.
     *
     * @param id id del libro
     * @return el libro
     * @throws NotFoundException si no existe
     */
    Book listBookById(Long id);

    /**
     * Lista los libros con ejemplares disponibles.
     *
     * @return libros con disponibles mayor que 0
     */
    List<Book> enableBooks();

    /**
     * Crea un libro.
     *
     * @param book datos del libro
     * @return el libro creado
     * @throws ValidateException si los datos no son válidos
     */
    Book addBook(Book book);

    /**
     * Modifica un libro.
     *
     * @param id id del libro
     * @param bk nuevos datos
     * @return el libro modificado
     * @throws NotFoundException si no existe
     * @throws ValidateException si los datos no son válidos
     */
    Book updateBook(Long id, Book bk);

    /**
     * Borra un libro.
     *
     * @param id id del libro
     * @throws NotFoundException si no existe
     */
    void deleteBook(Long id);
}