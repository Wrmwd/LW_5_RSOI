package by.rest.carsharing.repositories;

import by.rest.carsharing.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
