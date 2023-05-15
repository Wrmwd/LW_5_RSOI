package by.rest.carsharing.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Person {

    private @Id @GeneratedValue Long id;
    private String name;
    private int age;
    private int experience;

    @OneToMany(mappedBy="person")
    @JsonBackReference
    private List<Violation> violations;

    public Person() {}

    public Person(String name, int age, int expience) {
        this.name = name;
        this.age = age;
        this.experience = expience;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Violation> getViolations() {
        return violations;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setViolations(List<Violation> violations) {
        this.violations = violations;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", violations=" + violations +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(name, person.name) && Objects.equals(violations, person.violations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, violations);
    }
}
