package by.rest.carsharing.repositories;

import by.rest.carsharing.entities.Car;
import by.rest.carsharing.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long>{

}
