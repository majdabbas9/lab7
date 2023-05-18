package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String secondName;
    private String password;
    private String Email;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
    private List<Car> cars;
    @ManyToMany(mappedBy = "owners",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            targetEntity = Garage.class
    )
    private List<Garage> garages;

    public Person(String firstName,String secondName,String password) {
        this.firstName=firstName;
        this.secondName=secondName;
        this.password=password;
        this.Email=firstName+"."+secondName+"@"+"gmail.com";
        this.cars = new ArrayList<Car>();
        this.garages = new ArrayList<Garage>();
    }

    public Person() {

    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
    public void addCar(Car car)
    {
        this.cars.add(car);
    }

    public List<Garage> getGarages() {
        return garages;
    }

    public void setGarages(List<Garage> garages) {
        this.garages = garages;
    }
    public void addGarage(Garage garage)
    {
        this.garages.add(garage);
    }

    @Override
    public String toString() {
        String personToString="Owner ID = "+this.id+"\n";
        personToString+="Owner Name = "+this.firstName+" "+this.secondName+"\n";
        personToString+="Owner Email = "+this.Email+"\n";
        return personToString;
    }
}
