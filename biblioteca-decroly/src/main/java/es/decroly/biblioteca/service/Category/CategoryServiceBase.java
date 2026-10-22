package es.decroly.biblioteca.service.Category;

import es.decroly.biblioteca.domain.Category;
import es.decroly.biblioteca.exceptions.BadRequestException;
import es.decroly.biblioteca.exceptions.NotFoundException;
import es.decroly.biblioteca.exceptions.ValidateException;
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

        validar(cat, null);

        cat.setId(secuencia.incrementAndGet());

        categories.add(cat);

        log.info("Cada Categoria {} adicionada", cat.getId());


        return cat;
    }



    //Metodo par modificar una categoria ya creada

    @Override
    public Category updateCategory(Long id,Category cat) {
        validar(cat , id);


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

    private void validar(Category c, Long id) {
        if (c.getName() == null || c.getName().isBlank()) {
            throw new ValidateException("El nombre es obligatorio");
        }
        if (c.getName().trim().length() > 50) {
            throw new ValidateException("El nombre no puede superar los 50 caracteres");
        }

        for (Category existente : categories) {

            boolean esOtra = id == null || !existente.getId().equals(id);

            if (esOtra && existente.getName().equalsIgnoreCase(c.getName().trim())) {

                throw new ValidateException("Ya existe una categoria con ese nombre");

            }
        }
    }


}
