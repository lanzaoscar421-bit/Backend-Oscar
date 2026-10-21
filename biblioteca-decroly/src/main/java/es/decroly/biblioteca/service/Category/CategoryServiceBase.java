package es.decroly.biblioteca.service.Category;

import es.decroly.biblioteca.domain.Category;
import es.decroly.biblioteca.exceptions.BadRequestException;
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




    //Metodo de Listar
    @Override
    public List<Category> listCategory() {
        return categories;
    }



    //Metodo de Listar por Id que se introducira en Postman
    @Override
    public Category listByID(Long id){

        for (Category cat : categories) {
            if (cat.getId().equals(id)) {
                return cat;
            }
        }

        throw new NotFoundException("No Existe la categoria que busca");
    }

    @Override
    //Metodo de Crear Cataegorias
    public Category addCategory(Category cat) {

        validar(cat);

        cat.setId(secuencia.incrementAndGet());

        categories.add(cat);

        log.info("Cada Categoria {} adicionada", cat.getId());


        return cat;
    }



    //Metodo par modificar una categoria ya creada

    @Override
    public Category updateCategory(Long id,Category cat) {
        validar(cat);


        Category category = listByID(id);


        category.setName(cat.getName());
        category.setDescription(cat.getDescription());


        return category;
    }


    @Override
    //Metodo para borrar Categoria
    public void deleteCategory(Long id) {

        Category category = listByID(id);

        categories.remove(category);

    }




    //Metodo de Validaciones

    private void validar(Category c) {
        if (c.getName() == null || c.getName().isBlank()) {
            throw new BadRequestException("El nombre es obligatorio");
        }
        if (c.getDescription() == null || c.getDescription().isBlank()) {
            throw new BadRequestException("La descripcion es Obligatoria");
        }
    }


}
