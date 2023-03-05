package kata.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Getter
@AllArgsConstructor
@Entity
public class Categories {

    @Id
    @GeneratedValue
    private long id;
    private String cat_name;
    private String last_mod;
}