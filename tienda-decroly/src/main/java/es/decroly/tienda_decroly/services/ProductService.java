package es.decroly.tienda_decroly.services;

import es.decroly.tienda_decroly.domain.Producto;

import java.util.List;

public interface ProductService {


    List<Producto> listar();
    Producto buscarPorId(Long id);
    Producto crear(Producto producto);
    Producto modificar (Long id, Producto datos);
    void borrar (Long id);



}
