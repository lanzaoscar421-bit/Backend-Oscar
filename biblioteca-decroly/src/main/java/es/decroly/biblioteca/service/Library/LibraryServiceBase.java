package es.decroly.biblioteca.service.Library;

import es.decroly.biblioteca.config.LibraryProperties;
import es.decroly.biblioteca.dto.InfoLibraryDto;
import org.apache.tomcat.jni.Library;

public abstract class LibraryServiceBase implements LibraryService {

    private final LibraryProperties libraryProperties;

    public LibraryServiceBase(LibraryProperties libraryProperties) {
        this.libraryProperties = libraryProperties;
    }
    @Override
    public InfoLibraryDto getLibrary() {
        return new InfoLibraryDto(
                libraryProperties.nombre(),
                libraryProperties.maxPrestamos(),
                libraryProperties.diasPrestamo());
    }
}
