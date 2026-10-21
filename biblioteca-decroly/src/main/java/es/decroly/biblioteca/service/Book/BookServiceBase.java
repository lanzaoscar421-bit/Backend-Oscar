package es.decroly.biblioteca.service.Book;

import es.decroly.biblioteca.domain.Book;
import es.decroly.biblioteca.domain.Category;
import es.decroly.biblioteca.service.Category.CategoryService;
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


    @Override
    public List<Book> listBook(){
        return books;
    }



}
