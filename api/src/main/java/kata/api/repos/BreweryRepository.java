package kata.api.repos;

import kata.api.model.Breweries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreweryRepository extends JpaRepository<Breweries, Long> {
}