package es.decroly.tienda_decroly.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoRestController {

    @GetMapping("/saludo")
    public String saludo (){

        return "Hola Mundo desde la tienda de Decroly";
    }

    //Variable de ruta: http://localhost:8080/hola/migui


    @GetMapping("/saludo/{nombre}")
    public String saludoPersonalizado (@PathVariable String nombre){

        return "Hola " + nombre + " Bienvenido a la tienda de Decroly";
    }


}
