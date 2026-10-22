package es.decroly.biblioteca.service.Category;



import es.decroly.biblioteca.domain.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceMemoria extends CategoryServiceBase {



    public CategoryServiceMemoria() {

        super(List.of(
                new Category(1L, "Manga", "Cómic japonés"),
                new Category(2L, "Cómic", "Cómic occidental y novela gráfica")
        ));
    }

}
