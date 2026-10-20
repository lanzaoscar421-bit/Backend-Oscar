package es.decroly.biblioteca.service;

import es.decroly.biblioteca.domain.Category;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;
public interface CategoryService {


    List<Category> listar();
    Category listarID(Long id);
}
