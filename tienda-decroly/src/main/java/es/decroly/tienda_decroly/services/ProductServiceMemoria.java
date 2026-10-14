package es.decroly.tienda_decroly.services;

import es.decroly.tienda_decroly.domain.Producto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceMemoria extends ProductServiceBase{

    public ProductServiceMemoria() {
        super(List.of(
                new Producto(1L,"Compresas",30,33),
                new Producto(2L,"Mar",2123,1)
        ));
    }


}


