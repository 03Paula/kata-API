package kata.api.controller;

import kata.api.model.Categories;
import kata.api.repos.CategoryRepository;
import kata.api.errors.CategoryNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryRepository categoryRepository;

    /**
     * Obtenemos todas las categorias
     *
     * @return lista de categorias
     */
    @GetMapping("/categories")
    public List<Categories> getAllCategories(){
        return categoryRepository.findAll();
    }

    /**
     * Obtenemos una categoria por su ID
     *
     * @param id
     * @return categoria o un error 404 si esta no se encuentra
     */
    @GetMapping("category/{id}")
    public Categories getCategoryById(@PathVariable Long id){

        return categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));
    }
}
