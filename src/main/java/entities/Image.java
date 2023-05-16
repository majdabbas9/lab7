package entities;

import javax.persistence.*;
import java.net.URL;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String imageUrl;

    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;
    public Image(String imageUrl)
    {
        this.imageUrl=imageUrl;
    }

    public Image() {

    }

    public int getId() {
        return id;
    }

    public String getImageLink() {
        return imageUrl;
    }

    public void setImageUrl(String imageLink) {
        this.imageUrl = imageLink;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", imageUrl='" + imageUrl + '\'' +
                ", car=" + car +
                '}';
    }
}
