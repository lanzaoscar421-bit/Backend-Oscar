package es.decroly.biblioteca.service.Library;

import es.decroly.biblioteca.dto.InfoLibraryDto;

public interface LibraryService {

     /**
      * Devuelve la información de la biblioteca.
      *
      * @return nombre, máximo de préstamos y días de préstamo
      */
     InfoLibraryDto getLibrary();
}