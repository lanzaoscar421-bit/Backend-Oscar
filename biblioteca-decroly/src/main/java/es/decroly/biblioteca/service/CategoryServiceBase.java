package es.decroly.biblioteca.service;

import es.decroly.biblioteca.domain.Category;
import es.decroly.biblioteca.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public abstract class CategoryServiceBase implements CategoryService {

    private final List<Category> categories;
    private final AtomicLong secuencia;


    public  CategoryServiceBase(List<Category> categories) {
        this.categories = new ArrayList<>(categories);


        long maxId = 0;
        for (Category cat : categories) {
            if (cat.getId() > maxId) {
                maxId = cat.getId();
            }
        }
        this.secuencia = new AtomicLong(maxId);
    }

//    private final AtomicLong secuencia;

    @Override
    public List<Category> listar() {
        return categories;
    }


    @Override
    public Category listarID(Long id){

        for (Category cat : categories) {
            if (cat.getId().equals(id)) {
                return cat;
            }
        }

        throw new NotFoundException("No Existe la categoria que busca");
    }
}
