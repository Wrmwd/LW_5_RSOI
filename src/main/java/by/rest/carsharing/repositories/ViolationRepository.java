package by.rest.carsharing.repositories;

import by.rest.carsharing.entities.Violation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViolationRepository extends JpaRepository<Violation, Long> {
}
