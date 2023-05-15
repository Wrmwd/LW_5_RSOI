package by.rest.carsharing.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class Violation {
    private @Id @GeneratedValue Long id;

    private String violation_description;


    public Date violation_date;


    public Violation(String violation_description, Date violation_date) {
        this.violation_description = violation_description;
        this.violation_date = violation_date;
    }

    @Override
    public String toString() {
        return "Violation{" +
                "id=" + id +
                ", violation_name='" + violation_description + '\'' +
                ", violation_date=" + violation_date +
                ", person=" + person +
                '}';
    }





    @ManyToOne
    @JoinColumn(name="person_id", nullable=true)
    @JsonManagedReference
    private Person person;

    public Violation() {
    }

    public void setViolation_date(Date violation_date) {
        this.violation_date = violation_date;
    }

    public Date getViolation_date() {
        return violation_date;
    }
    public Violation(String violation_name) {
        this.violation_description = violation_name;
    }

    public Long getId() {
        return id;
    }

    public String getViolation_name() {
        return violation_description;
    }

    public Person getPerson() {
        return person;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setViolation_name(String violation_name) {
        this.violation_description = violation_name;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Violation violation = (Violation) o;
        return Objects.equals(id, violation.id) && Objects.equals(violation_date, violation.violation_date)&& Objects.equals(violation_description, violation.violation_description) && Objects.equals(person, violation.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, violation_description, violation_date, person);
    }
}
