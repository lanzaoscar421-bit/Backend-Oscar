package es.decroly.biblioteca.service.Library;

import es.decroly.biblioteca.config.LibraryProperties;
import org.springframework.stereotype.Service;

@Service
public class LibraryServiceMemoria extends LibraryServiceBase {

    public LibraryServiceMemoria(LibraryProperties libraryProperties) {
        super(libraryProperties);
    }
}