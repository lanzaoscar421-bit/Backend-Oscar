package es.decroly.biblioteca.service.Book;

import es.decroly.biblioteca.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceMemoria extends BookServiceBase {

    public BookServiceMemoria() {

        super(List.of(

                new Book(1L, "978-84-9114-001-1", "Dragon Ball Vol. 1", "Akira Toriyama", 1985, 5, 5, 1L),
                new Book(1L, "978-84-9114-001-1", "Dragon Ball Vol. 1", "Akira Toriyama", 1985, 5, 5, 1L),
                new Book(2L, "978-84-9114-002-8", "One Piece Vol. 1", "Eiichiro Oda", 1997, 6, 4, 1L),
                new Book(3L, "978-84-9114-003-5", "Naruto Vol. 1", "Masashi Kishimoto", 1999, 4, 4, 1L),
                new Book(7L, "978-84-9114-007-3", "Batman: Año Uno", "Frank Miller", 1987, 2, 1, 2L),
                new Book(8L, "978-84-9114-008-0", "Maus", "Art Spiegelman", 1991, 3, 3, 2L)


        ));
    }
}
