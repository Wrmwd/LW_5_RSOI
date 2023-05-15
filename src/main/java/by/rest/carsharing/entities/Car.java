package by.rest.carsharing.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Calendar;
import java.util.List;

@Entity
public class Car {

    private @Id
    @GeneratedValue Long id;
    private String vin;
    private int number;
    private String  model;
    private int odometr;

    public List<Travel> getTravels() {
        return travels;
    }

    @OneToMany(mappedBy="car")
    @JsonManagedReference
    private List<Travel> travels;

    public Car( String vin, int number, String model, int odometr) {

        this.vin = vin;
        this.number = number;
        this.model = model;
        this.odometr = odometr;
    }
    public Car() {
    }
    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", vin='" + vin + '\'' +
                ", number=" + number +
                ", model='" + model + '\'' +
                ", odometr=" + odometr +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getVin() {
        return vin;
    }

    public int getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }
    public int getSizeTravel() {
        return travels.size();
    }
    public int getOdometr() {
        return odometr;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setOdometr(int odometr) {
        this.odometr = odometr;
    }

    public List<Travel> getTravelsSort( int month) {
        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.MONTH,month);

       for (var  travel: travels) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(travel.travel_date);
            if (cal1.get(Calendar.MONTH) == (cal.get(Calendar.MONTH))) {

                break;

            }
        }
        return travels;
    }


}
