package kata.api.dto.converter;

import kata.api.model.Beers;
import kata.api.model.Styles;
import kata.api.dto.BeerDTO;
import kata.api.dto.StyleDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StyleDTOConverter {

    private final ModelMapper modelMapper;

    public StyleDTO convertToDTO(Styles style){
        return modelMapper.map(style,StyleDTO.class);
    }
}