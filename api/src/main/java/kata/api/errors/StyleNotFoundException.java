package kata.api.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StyleNotFoundException extends RuntimeException{
    private static final  long serialVersionUID = 43876691117560211L;

    public StyleNotFoundException(Long id){
        super("Estilo inexistente. ID = " + id);
    }
}
