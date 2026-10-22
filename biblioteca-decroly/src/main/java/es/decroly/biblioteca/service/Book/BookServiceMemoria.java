package es.decroly.biblioteca.service.Book;

import es.decroly.biblioteca.domain.Book;
import es.decroly.biblioteca.service.Category.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceMemoria extends BookServiceBase {

    public BookServiceMemoria(CategoryService categoryService) {

        super(categoryService, List.of(

                new Book(1L, "9788491140011", "Dragon Ball Vol. 1", "Akira Toriyama", 1985, 5, 5, 1L),
                new Book(2L, "9788491140028", "Dragon Ball Vol. 2", "Akira Toriyama", 1985, 5, 5, 1L),
                new Book(3L, "9788491140035", "One Piece Vol. 1", "Eiichiro Oda", 1997, 6, 4, 1L),
                new Book(4L, "9788491140042", "Naruto Vol. 1", "Masashi Kishimoto", 1999, 4, 4, 1L),
                new Book(5L, "9788491140073", "Batman: Año Uno", "Frank Miller", 1987, 2, 1, 2L),
                new Book(6L, "9788491140080", "Maus", "Art Spiegelman", 1991, 3, 3, 2L)

        ));
    }
}