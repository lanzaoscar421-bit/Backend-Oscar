package es.decroly.biblioteca.service.Category;

import es.decroly.biblioteca.domain.Category;


import java.util.List;
public interface CategoryService {


    List<Category> listCategory();
    Category listByID(Long id);
    Category addCategory(Category cat);
    Category updateCategory(Long id,Category cat);
    void deleteCategory(Long id);
}
