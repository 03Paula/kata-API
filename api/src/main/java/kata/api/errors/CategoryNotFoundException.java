package kata.api.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CategoryNotFoundException extends RuntimeException{
    private static final  long serialVersionUID = 43876691145660211L;

    public CategoryNotFoundException(Long id){
        super("Categoría inexistente. ID = " + id);
    }
}
