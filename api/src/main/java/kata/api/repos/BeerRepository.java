package kata.api.repos;

import kata.api.model.Beers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerRepository extends JpaRepository<Beers, Long>{
}