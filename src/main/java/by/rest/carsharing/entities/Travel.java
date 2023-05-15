package by.rest.carsharing.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class Travel {

    public String getTravel_cost() {
        return travel_cost;
    }

    private @Id
    @GeneratedValue Long id;
    public String travel_cost;
    public Date travel_date;


    @ManyToOne
    @JoinColumn(name="person_id", nullable=true)
    @JsonManagedReference
    private Person person;

    @ManyToOne
    @JoinColumn(name="car_id", nullable=true)
    @JsonBackReference
    private Car car;

    public Travel(String travel_cost, Date travel_date) {
        this.travel_cost = travel_cost;
        this.travel_date = travel_date;

    }

    public Travel() {
    }



    public void setTravel_cost(String travel_cost) {
        this.travel_cost = travel_cost;
    }

    public void setTravel_date(Date travel_date) {
        this.travel_date = travel_date;
    }
    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Travel{" +
                "travel_cost=" + travel_cost +
                ", travel_date=" + travel_date +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Travel travel = (Travel) o;
        return Objects.equals(id, travel.id) && Objects.equals(travel_cost, travel.travel_cost)&& Objects.equals(travel_date, travel.travel_date) && Objects.equals(person, travel.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, travel_cost, travel_date, person);
    }


    public void setPerson(Person person) {
        this.person = person;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }
}



