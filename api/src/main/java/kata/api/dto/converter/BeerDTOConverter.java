
package kata.api.dto.converter;

        import kata.api.model.Beers;
        import kata.api.dto.BeerDTO;
        import lombok.RequiredArgsConstructor;
        import org.modelmapper.ModelMapper;
        import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BeerDTOConverter {

    private final ModelMapper modelMapper;

    public BeerDTO convertToDTO(Beers beer){
        return modelMapper.map(beer,BeerDTO.class);
    }
}