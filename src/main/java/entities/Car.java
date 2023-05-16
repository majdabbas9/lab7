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
@Table(name = "cars")
public class Car
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String licensePlate;
    private double price;
    @Column(name = "manufacturing_year")
    private int year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person owner;
    @OneToOne
    @JoinColumn(name = "image_id")
    private Image image;
    @ManyToMany(mappedBy = "cars",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            targetEntity = Garage.class
    )
    private List<Garage> garages;
    public Car(String licensePlate, double price, int year,Person person) {
        super();
        this.licensePlate = licensePlate;
        this.price = price;
        this.year = year;
        setPerson(person);
        this.garages=new ArrayList<>();
    }

    public Car() {

    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getId() {
        return id;
    }

    public Person getPerson() {
        return owner;
    }

    public void setPerson(Person person) {
        this.owner = person;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public List<Garage> getGarages() {
        return garages;
    }

    public void setGarages(List<Garage> garages) {
        this.garages = garages;
    }
    public void addGarge(Garage garage)
    {
        this.garages.add(garage);
    }

    @Override
    public String toString() {
        String carToString="car id=" + id +
                "\nlicensePlate=" + licensePlate +
                "\nprice=" + price
                +"\nyear=" + year +
                "\nimageUrl="
                + image.getImageLink()+"\n";
        carToString+=owner.toString();
        for(int i=0;i<garages.size();i++)
        {
            carToString+="garage number="+(i+1)+" adress="+garages.get(i).getAdress()+"\n";
        }
        return carToString;
    }
}
