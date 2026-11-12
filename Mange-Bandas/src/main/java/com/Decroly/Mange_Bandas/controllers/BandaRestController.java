package com.Decroly.Mange_Bandas.controllers;
import com.Decroly.Mange_Bandas.Service.Banda.BandaService;
import com.Decroly.Mange_Bandas.Service.BandasInfo.InfoBandasService;
import com.Decroly.Mange_Bandas.domain.Banda;
import com.Decroly.Mange_Bandas.dto.BandaDto;
import com.Decroly.Mange_Bandas.dto.InfoBandasDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Bandas", description = "Gestion de bandas")
@RequiredArgsConstructor
@RestController
@RequestMapping("api/banda")
public class BandaRestController {

    private final BandaService bandaService;


    @GetMapping("")
    public List<Banda>getBanda(){
        return bandaService.listBandas();
    }


    @GetMapping("/{id}")
    public Banda getBandaById(@PathVariable Long id){
        return bandaService.listaBandaId(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void delBanda(@PathVariable Long id){
         bandaService.delBanda(id);
    }


    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
        public Banda addBanda(@RequestBody  BandaDto banda){
        return  bandaService.addBanda(banda);
    }

    @PutMapping("/{id}")
    public Banda updateBanda(@PathVariable Long id,@RequestBody BandaDto banda){

        return bandaService.updateBanda(id,banda);
    }

//    @RequiredArgsConstructor
//    @RestController
//    @RequestMapping("api/info")
//    public class InfoBandasRestController {
//
//        private final InfoBandasService infoBandasService;
//
//        @GetMapping
//        public InfoBandasDto info() {
//            return infoBandasService.getInfo();
//        }
//    }


//    @Operation(summary = "Lista las bandas")
//    @ApiResponse(responseCode = "200", description = "Lista devuelta")
//    @GetMapping("")
//    ...
//
//    @Operation(summary = "Obtiene una banda por id")
//    @ApiResponse(responseCode = "200", description = "Banda encontrada")
//    @ApiResponse(responseCode = "404", description = "No existe la banda")
//    @GetMapping("/{id}")
//    ...
//
//    @Operation(summary = "Crea una banda")
//    @ApiResponse(responseCode = "201", description = "Banda creada")
//    @ApiResponse(responseCode = "400", description = "Datos no validos")
//    @ApiResponse(responseCode = "409", description = "Nombre repetido")
//    @PostMapping("")
//    ...
//
//    @Operation(summary = "Modifica una banda")
//    @ApiResponse(responseCode = "200", description = "Banda modificada")
//    @ApiResponse(responseCode = "400", description = "Datos no validos")
//    @ApiResponse(responseCode = "404", description = "No existe la banda")
//    @ApiResponse(responseCode = "409", description = "Nombre repetido")
//    @PutMapping("/{id}")
//    ...
//
//    @Operation(summary = "Borra una banda")
//    @ApiResponse(responseCode = "204", description = "Banda borrada")
//    @ApiResponse(responseCode = "404", description = "No existe la banda")
//    @DeleteMapping("/{id}")
}
