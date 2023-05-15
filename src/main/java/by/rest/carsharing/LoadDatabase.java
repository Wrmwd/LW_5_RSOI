package by.rest.carsharing;

import by.rest.carsharing.entities.Car;
import by.rest.carsharing.entities.Person;
import by.rest.carsharing.entities.Travel;
import by.rest.carsharing.entities.Violation;
import by.rest.carsharing.repositories.PersonRepository;
import by.rest.carsharing.repositories.TravelRepository;
import by.rest.carsharing.repositories.ViolationRepository;
import by.rest.carsharing.repositories.CarRepository;

import jakarta.persistence.SecondaryTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(PersonRepository personRepository, ViolationRepository violationRepository, TravelRepository travelRepository,CarRepository carRepository) {
        return args -> {


            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

            Person person1 = new Person("Polina", 20, 1);
            log.info("Preloading " + personRepository.save(person1));
            Violation violation1 = new Violation("Violation1", new Date());
            violation1.setPerson(person1);
            log.info("Preloading " + violationRepository.save(violation1));

            Violation violation2 = new Violation("Violation2", new Date());
            violation2.setPerson(person1);
            log.info("Preloading " + violationRepository.save(violation2));

            Violation violation3 = new Violation("Violation3", new Date());
            violation3.setPerson(person1);
            log.info("Preloading " + violationRepository.save(violation3));
//////////////


            Car car1 = new Car( "4HGCM8272GD005243",23,"CHEVROLET CAMARO LT",123000);
            log.info("Preloading " + carRepository.save(car1));
            Car car2 = new Car( "652JS79632A005243",13,"DODGE CHALLENGER SXT",388000);
            log.info("Preloading " + carRepository.save(car2));
            Car car3 = new Car( "879QH2412JHG99381",15,"CHRYSLER 300",77000);
            log.info("Preloading " + carRepository.save(car3));


            Travel travel1 = new Travel("Travel1",formatter.parse("01/11/2020"));
            travel1.setPerson(person1);
            travel1.setCar(car1);
            log.info("Preloading " + travelRepository.save(travel1));

            Travel travel2 = new Travel("travel2", new Date());
            travel2.setPerson(person1);
            travel2.setCar(car2);
            log.info("Preloading " + travelRepository.save(travel2));

            Travel travel3 = new Travel("travel3", new Date());
            travel2.setCar(car2);
            travel3.setPerson(person1);
            log.info("Preloading " + travelRepository.save(travel3));

            log.info("Preloading " + person1);


            Person person2 = new Person("Dianene", 19, 1);
            log.info("Preloading " + personRepository.save(person2));
            Travel travel10 = new Travel("Travel10",formatter.parse("01/11/2020"));
            travel10.setCar(car3);
            travel10.setPerson(person2);
            log.info("Preloading " + travelRepository.save(travel10));

            Travel travel20 = new Travel("Travel20", formatter.parse("01/11/2020"));
            travel20.setCar(car3);
            travel20.setPerson(person2);
            log.info("Preloading " + travelRepository.save(travel20));

            Travel travel30 = new Travel("Travel30",formatter.parse("01/11/2020"));
            travel30.setCar(car3);
            travel30.setPerson(person2);
            log.info("Preloading " + travelRepository.save(travel30));

            log.info("Preloading " + person2);

        };
    }
}
