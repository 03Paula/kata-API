package kata.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class ModBeerDTO {

    private long breweryId;

    private String name;

    private long categoryId;

    private long styleId;

    private float abv;
    private float ibu;
    private float srm;
    private int upc;
    private String filepath;
    private String descript;
    private Integer add_user;

    private LocalDateTime last_mod;

}