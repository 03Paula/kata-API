package kata.api.controller;


import kata.api.repos.BeerRepository;
import kata.api.model.Beers;
import kata.api.repos.BreweryRepository;
import kata.api.repos.CategoryRepository;
import kata.api.repos.StyleRepository;
import kata.api.dto.BeerDTO;
import kata.api.dto.CreateBeerDTO;
import kata.api.dto.ModBeerDTO;
import kata.api.dto.converter.BeerDTOConverter;
import kata.api.errors.BeerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
public class BeerController {

    private final BeerRepository beerRepository;
    private final CategoryRepository categoryRepository;
    private final BreweryRepository breweryRepository;
    private final StyleRepository styleRepository;
    private final BeerDTOConverter beerDTOConverter;


    /**
     * Obtención de todas las cervezas del listado.
     *
     * @return Lista de cervezas
     */
    @GetMapping("/beers")
    public ResponseEntity<List<?>> getAllBeers(){
        List<Beers> beers = beerRepository.findAll();
        if(beers.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {

            List<BeerDTO> dtoList =
                    beers.stream().map(beerDTOConverter::convertToDTO).collect(Collectors.toList());
            return ResponseEntity.ok(dtoList);
        }
    }

    /**
     * Obtención de una cerveza con su ID correspondiente
     *
     * @param id Identificación de la cerveza
     * @return Cerveza | 404
     */
    @GetMapping("beer/{id}")
    public Beers getBeerById(@PathVariable Long id){

        return beerRepository.findById(id)
                .orElseThrow(() -> new BeerNotFoundException(id));
    }

    /**
     * Eliminación de una cerveza con su ID correspondiente
     *
     * @param id Identificador de la cerveza
     * @return Código 204
     */
    @DeleteMapping("/beer/{id}")
    public ResponseEntity<Void> deleteBeerById(@PathVariable Long id){
        Beers beer = beerRepository.findById(id).orElseThrow(() -> new BeerNotFoundException(id));
        beerRepository.delete(beer);
        return ResponseEntity.noContent().build();
    }

    /**
     * Creación de una nueva cerveza
     *
     * @param newBeer Nueva cerveza
     * @return Cerveza insertada
     */
    @PostMapping("/beer")
    public ResponseEntity<?> newBeer(@RequestBody CreateBeerDTO newBeer){
        Beers nBeer = new Beers();
        //Para poder meter el repositorio completo necesitamos buscarlo usando un "id" que le pasamos en el DTO
        nBeer.setBrewery(breweryRepository.findById(newBeer.getBreweryId()).orElse(null));
        nBeer.setName(newBeer.getName());
        nBeer.setCategory(categoryRepository.findById(newBeer.getCategoryId()).orElse(null));
        nBeer.setStyle(styleRepository.findById(newBeer.getStyleId()).orElse(null));
        nBeer.setAbv(newBeer.getAbv());
        nBeer.setIbu(newBeer.getIbu());
        nBeer.setSrm(newBeer.getSrm());
        nBeer.setUpc(newBeer.getUpc());
        nBeer.setFilepath(newBeer.getFilepath());
        nBeer.setDescript(newBeer.getDescript());
        nBeer.setAdd_user(newBeer.getAdd_user());
        nBeer.setLast_mod(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(beerRepository.save(nBeer));
    }

    /**
     * Actualizamos una cerveza
     *
     * @param newBeer Datos de cerveza nueva
     * @param id Identificación de la cerveza
     * @return Cerveza actualizada | 404
     */
    @PutMapping("/beer/{id}")
    public Beers updateBeer(@RequestBody ModBeerDTO newBeer, @PathVariable Long id) {
        return beerRepository.findById(id).map(b -> {
            b.setBrewery(breweryRepository.findById(newBeer.getBreweryId()).orElse(null));
            b.setName(newBeer.getName());
            b.setCategory(categoryRepository.findById(newBeer.getCategoryId()).orElse(null));
            b.setStyle(styleRepository.findById(newBeer.getStyleId()).orElse(null));
            b.setAbv(newBeer.getAbv());
            b.setIbu(newBeer.getIbu());
            b.setSrm(newBeer.getSrm());
            b.setUpc(newBeer.getUpc());
            b.setFilepath(newBeer.getFilepath());
            b.setDescript(newBeer.getDescript());
            b.setAdd_user(newBeer.getAdd_user());
            b.setLast_mod(LocalDateTime.now());
            return beerRepository.save(b);
        }).orElseThrow(() -> new BeerNotFoundException(id));
    }
}
