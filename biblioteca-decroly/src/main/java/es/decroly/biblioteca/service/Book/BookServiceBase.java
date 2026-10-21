package es.decroly.biblioteca.service.Book;

import es.decroly.biblioteca.domain.Book;
import es.decroly.biblioteca.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public abstract class BookServiceBase  implements BookService {

    private final List<Book> books;
    private final AtomicLong secuencia;

    public  BookServiceBase(List<Book> books) {
        this.books = new ArrayList<>(books);


        long maxId = 0;
        for (Book book : books) {
            if (book.getId() > maxId) {
                maxId = book.getId();
            }
        }
        this.secuencia = new AtomicLong(maxId);
    }



    //Ver todos los libros
    @Override
    public List<Book> listBook(){
        return books;
    }


    //Filtrar los libros por id
    @Override
    public Book listBookById(Long id){

        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        throw new NotFoundException("No Existe el libro que busca");
    }

    // Ver todos los libros disponibles
    public List<Book> enableBooks(){
        List<Book> disponibles = new ArrayList<>();

        for (Book book : books) {
            if (book.getAvailable() > 0) {
                disponibles.add(book);
            }
        }

        return disponibles;
    }




}
