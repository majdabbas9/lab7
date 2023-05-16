package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "garages")
public class Garage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String adress;
    private String phoneNumber;
    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            targetEntity = Person.class
    )
    @JoinTable(
            name="owners_garages",
            joinColumns = @JoinColumn(name = "garage_id"),
            inverseJoinColumns = @JoinColumn(name = "owner_id")
    )
    private List<Person>owners ;

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            targetEntity = Car.class
    )
    @JoinTable(
            name="cars_garages",
            joinColumns = @JoinColumn(name = "garage_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id")
    )
    private List<Car>cars ;

    public Garage(String adress,String phoneNumber) {
        this.adress = adress;
        this.phoneNumber=phoneNumber;
        this.owners=new ArrayList<>();
        this.cars=new ArrayList<>();
    }

    public Garage() {
        
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Person> getOwnersList() {
        return owners;
    }

    public void setOwnersList(List<Person> ownersList) {
        this.owners = ownersList;
    }
    public void addOwner(Person person)
    {
        this.owners.add(person);
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

    @Override
    public String toString() {
        int i;
        String gargeToString=owners.get(0).getFirstName()+" "+owners.get(0).getSecondName() + "Garage";
        gargeToString+="\nid=" + id + "\nadress=" + adress + "\nphoneNumber=" + phoneNumber+"\n";
        for(i=0;i<cars.size();i++)
        {
            gargeToString+="car number "+(i+1)+" "+"plate number="+cars.get(i).getLicensePlate()+"\n";
        }
        return  gargeToString;
    }
}
