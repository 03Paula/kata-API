package kata.api.repos;

import kata.api.model.Styles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StyleRepository extends JpaRepository<Styles, Long>{
}