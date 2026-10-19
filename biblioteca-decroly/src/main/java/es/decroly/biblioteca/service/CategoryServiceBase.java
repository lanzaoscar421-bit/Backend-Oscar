package es.decroly.biblioteca.service;

import es.decroly.biblioteca.domain.Category;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public abstract class CategoryServiceBase implements CategoryService {

    private final List<Category> categories;



//    private final AtomicLong secuencia;

    @Override
    public List<Category> listar() {
        return categories;
    }

}
