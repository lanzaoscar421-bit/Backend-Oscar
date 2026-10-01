package es.decroly.tienda_decroly.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TiendaRestController {


    @GetMapping("/info")
    public String info(){

        return "Tienda Decroly | <br>" +
                "Cuidad: Santander | <br>" +
                "Horario: 10:00-14:00 16:00-20:00 |";
    }


    @GetMapping("/descuento/{precio}")
    public String descuento(@PathVariable double precio, @RequestParam(defaultValue = "10") double porcentaje){


        double precioFinal = precio - (precio * porcentaje / 100);

        return "precio del principio " + precio  + " precio: " + precioFinal + " porcentaje: " + porcentaje;
    }



}
