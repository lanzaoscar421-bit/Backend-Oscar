package com.Decroly.Mange_Bandas.controllers;

import com.Decroly.Mange_Bandas.Service.Banda.BandaService;
import com.Decroly.Mange_Bandas.domain.Banda;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public  void delBanda(@PathVariable Long id){
         bandaService.delBanda(id);
    }


    @PostMapping("")
    public Banda addBanda(@RequestBody Banda banda){
        return  bandaService.addBanda(banda);
    }
}
