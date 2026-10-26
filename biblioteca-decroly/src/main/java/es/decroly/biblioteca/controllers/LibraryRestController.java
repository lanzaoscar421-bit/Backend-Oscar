package es.decroly.biblioteca.controllers;

import es.decroly.biblioteca.config.LibraryProperties;
import es.decroly.biblioteca.dto.InfoLibraryDto;
import es.decroly.biblioteca.service.Library.LibraryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "library", description = "Informacion general de la biblioteca")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/biblioteca")
public class LibraryRestController {

    private final LibraryService libraryService;



    @Operation(summary = "Informacion de la biblioteca",
            description = "Nombre, maximo de prestamos y dias de prestamo configurados")
    @ApiResponse(responseCode = "200", description = "Informacion devuelta correctamente")

    @GetMapping("/info")
    public InfoLibraryDto info() {
        return libraryService.getLibrary();
    }

}
