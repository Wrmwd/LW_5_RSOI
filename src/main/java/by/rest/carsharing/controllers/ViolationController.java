package by.rest.carsharing.controllers;

import java.util.List;

import by.rest.carsharing.entities.Person;
import by.rest.carsharing.entities.Violation;
import by.rest.carsharing.exeptions.PersonNotFoundException;
import by.rest.carsharing.exeptions.ViolationNotFoundException;
import by.rest.carsharing.repositories.ViolationRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViolationController {
    private final ViolationRepository repository;

    public ViolationController(ViolationRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/violations")
    List<Violation> all() {
        return repository.findAll();
    }

    @PostMapping("/violations")
    Violation newViolation(@RequestBody Violation newViolation) {
        return repository.save(newViolation);
    }

    @GetMapping("/violations/{id}")
    Violation one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ViolationNotFoundException(id));
    }

    @PutMapping("/violations/{id}")
    Violation replaceViolation(@RequestBody Violation newViolation, @PathVariable Long id) {

        return repository.findById(id)
                .map(violation -> {
                    violation.setViolation_name(newViolation.getViolation_name());
                    return repository.save(violation);
                })
                .orElseGet(() -> {
                    newViolation.setId(id);
                    return repository.save(newViolation);
                });
    }

    @DeleteMapping("/violations/{id}")
    void deleteViolation(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
