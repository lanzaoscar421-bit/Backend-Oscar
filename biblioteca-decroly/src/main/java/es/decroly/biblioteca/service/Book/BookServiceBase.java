package es.decroly.biblioteca.service.Book;

import es.decroly.biblioteca.domain.Book;
import es.decroly.biblioteca.exceptions.BadRequestException;
import es.decroly.biblioteca.exceptions.NotFoundException;
import es.decroly.biblioteca.exceptions.ValidateException;
import es.decroly.biblioteca.service.Category.CategoryService;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public abstract class BookServiceBase  implements BookService {

    private final List<Book> books;
    private final AtomicLong secuencia;


    private final CategoryService categoryService;

    public  BookServiceBase(CategoryService categoryService,List<Book> books) {
        this.categoryService = categoryService;
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

    @Override
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

    @Override
    public Book addBook(Book book){

        validar(book, null);

        book.setId(secuencia.incrementAndGet());
        books.add(book);

        log.info("Cada Categoria {} adicionada", book.getId());

        return book;

    }

    @Override
    public Book updateBook(Long id , Book bk){

        validar(bk, id);

        Book book = listBookById(id);

        book.setTitle(bk.getTitle());
        book.setAuthor(bk.getAuthor());
        book.setPublicationYear(bk.getPublicationYear());
        book.setCopies(bk.getCopies());
        book.setAvailable(bk.getAvailable());
        book.setCategoryId(bk.getCategoryId());

        return book;
    }

    @Override
    public void  deleteBook(Long id){
        Book book = listBookById(id);
        books.remove(book);

    }


    //Metodo validar
    private void validar(Book b, Long id) {

        if (b.getIsbn() == null || !b.getIsbn().matches("\\d{13}")) {
            throw new ValidateException("El ISBN debe de tener exactamente 13 cifras");
        }
        for (Book existente : books) {
            boolean esOtro = id == null || !existente.getId().equals(id);

            if (esOtro && existente.getIsbn().equals(b.getIsbn())) {

                throw new ValidateException("Ya existe un libro con ese ISBN");
            }
        }
        if (b.getTitle() == null || b.getTitle().isBlank()) {
            throw new ValidateException("El titulo es obligatorio");
        }
        if (b.getAuthor() == null || b.getAuthor().isBlank()) {
            throw new ValidateException("El autor es obligatorio");
        }
        if (b.getCopies() < 1) {
            throw new ValidateException("Los ejemplares deben ser al menos 1");
        }
        if (b.getCategoryId() == null) {
            throw new ValidateException("La categoria es obligatoria");
        }
        boolean categoriaExiste = categoryService.listCategory().stream()
                .anyMatch(c -> c.getId().equals(b.getCategoryId()));
        if (!categoriaExiste) {
            throw new ValidateException("La categoria indicada no existe");
        }
    }

}
