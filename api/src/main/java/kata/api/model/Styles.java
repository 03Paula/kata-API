package kata.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Getter
@AllArgsConstructor
@Entity
public class Styles {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name="cat_id")
    private Categories category;
    private String style_name;
    private String last_mod;
}