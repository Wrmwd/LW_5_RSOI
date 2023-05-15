package by.rest.carsharing.controllers;

import by.rest.carsharing.entities.Travel;
import by.rest.carsharing.exeptions.TravelNotFoundException;
import by.rest.carsharing.repositories.TravelRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TravelController {
    private final TravelRepository repository;

    public TravelController(TravelRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/travels")
    List<Travel> all() {
        return repository.findAll();
    }

    @PostMapping("/travels")
    Travel newViolation(@RequestBody Travel newViolation) {
        return repository.save(newViolation);
    }

    @GetMapping("/travels/{id}")
    Travel one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new TravelNotFoundException(id));
    }

    @PutMapping("/travels/{id}")
    Travel replaceTravel(@RequestBody Travel newTravel, @PathVariable Long id) {

        return repository.findById(id)
                .map(violation -> {
                    violation.setTravel_cost(newTravel.getTravel_cost());
                    return repository.save(violation);
                })
                .orElseGet(() -> {
                    newTravel.setId(id);
                    return repository.save(newTravel);
                });
    }

    @DeleteMapping("/travels/{id}")
    void deleteViolation(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
