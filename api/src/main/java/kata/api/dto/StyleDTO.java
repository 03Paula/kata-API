package kata.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StyleDTO {

    private long id;

    private long categoryId;

    private String style_name;

    private String last_mod;


}