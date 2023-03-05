package kata.api.controller;

import kata.api.repos.BreweryRepository;
import kata.api.model.Breweries;
import kata.api.errors.BrewerieNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BreweriesController {

    private final BreweryRepository breweryRepository;

    /**
     * Obtención de todas las cervecerías del listado
     *
     * @return Lista de cervecerías
     */
    @GetMapping("/breweries")
    public List<Breweries> getAllBreweries(){
        return breweryRepository.findAll();
    }

    /**
     * Obtención de una cervecería con su ID correspondiente
     *
     * @param id Identificación de la cervecería
     * @return Cervecería | 404
     */
    @GetMapping("brewery/{id}")
    public Breweries getBreweryById(@PathVariable Long id){

        return breweryRepository.findById(id).orElseThrow(() -> new BrewerieNotFoundException(id));
    }
}
