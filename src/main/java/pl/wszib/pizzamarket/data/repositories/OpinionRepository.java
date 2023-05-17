package pl.wszib.pizzamarket.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wszib.pizzamarket.data.entities.OpinionEntity;

public interface OpinionRepository extends JpaRepository<OpinionEntity, Long> {
}
