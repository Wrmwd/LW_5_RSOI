package by.rest.carsharing.controllers;

import by.rest.carsharing.entities.Car;
import by.rest.carsharing.entities.Travel;
import by.rest.carsharing.exeptions.TravelNotFoundException;
import by.rest.carsharing.repositories.CarRepository;
import by.rest.carsharing.repositories.TravelRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class CarController {
    private final CarRepository repository;

    public CarController(CarRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/cars")
    List<Car> all() {
        return repository.findAll();
    }

    @GetMapping("/sortcars")
    List<Car> allSorted() {
        List<Car> db_list = repository.findAll();
        class ComparatorByAvgMark implements Comparator<Car> {
            @Override
            public int compare(Car o1, Car o2) {
                return Integer.compare(o1.getSizeTravel(), o2.getSizeTravel());
            }
        }

        Collections.sort(db_list, new ComparatorByAvgMark());
        Collections.reverse(db_list);


        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.MONTH, 3);

        List<Car> db_list_sorted = db_list.stream().filter(car -> hasTravelInMonth(car.getTravels(), 3)).collect(Collectors.toList());
        return db_list_sorted;
    }

    private boolean hasTravelInMonth(List<Travel> list, int month) {
        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.MONTH, month);
        boolean hasTravel = false;
        for (var travel : list) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(travel.travel_date);
            if (cal1.get(Calendar.MONTH) == (cal.get(Calendar.MONTH))) {
                hasTravel = true;
                break;
            }
        }
        return hasTravel;
    }

    @PostMapping("/cars")
    Car newCar(@RequestBody Car newCar) {
        return repository.save(newCar);
    }

    @GetMapping("/cars/{id}")
    Car one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new TravelNotFoundException(id));
    }

    @PutMapping("/cars/{id}")
    Car replaceCar(@RequestBody Car newCar, @PathVariable Long id) {

        return repository.findById(id)
                .map(car -> {
                    car.setModel(newCar.getModel());
                    return repository.save(car);
                })
                .orElseGet(() -> {
                    newCar.setId(id);
                    return repository.save(newCar);
                });
    }

    @DeleteMapping("/cars/{id}")
    void deleteCar(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
