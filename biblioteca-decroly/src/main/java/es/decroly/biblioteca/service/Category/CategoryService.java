package es.decroly.biblioteca.service.Category;

import es.decroly.biblioteca.domain.Category;
import es.decroly.biblioteca.exceptions.NotFoundException;
import es.decroly.biblioteca.exceptions.ValidateException;

import java.util.List;

public interface CategoryService {

    /**
     * Lista todas las categorías.
     *
     * @return todas las categorías
     */
    List<Category> listCategory();

    /**
     * Busca una categoría por id.
     *
     * @param id id de la categoría
     * @return la categoría
     * @throws NotFoundException si no existe
     */
    Category listByID(Long id);

    /**
     * Crea una categoría.
     *
     * @param cat datos de la categoría
     * @return la categoría creada
     * @throws ValidateException si el nombre falta, es muy largo o ya existe
     */
    Category addCategory(Category cat);

    /**
     * Modifica una categoría.
     *
     * @param id id de la categoría
     * @param cat nuevos datos
     * @return la categoría modificada
     * @throws NotFoundException si no existe
     * @throws ValidateException si los datos no son válidos
     */
    Category updateCategory(Long id, Category cat);

    /**
     * Borra una categoría.
     *
     * @param id id de la categoría
     * @throws NotFoundException si no existe
     */
    void deleteCategory(Long id);
}