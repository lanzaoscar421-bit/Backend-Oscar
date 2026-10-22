package es.decroly.biblioteca.service.Book;

import es.decroly.biblioteca.domain.Book;

import java.util.List;

public interface BookService {

    List<Book> listBook();
    Book listBookById(Long id);
    List<Book> enableBooks( );
    Book addBook(Book book);
    Book updateBook(Long id,Book book);
    void deleteBook(Long id);

}
