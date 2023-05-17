package org.example;

/**
 * Hello world!
 *
 */
import entities.Car;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import entities.Garage;
import entities.Image;
import entities.Person;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
public class App
{
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String GREEN_BOLD = "\033[1;32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    private static Session session;

    private static SessionFactory getSessionFactory() throws HibernateException {
        Configuration configuration =new Configuration();
        configuration.addAnnotatedClass(Car.class);
        configuration.addAnnotatedClass(Person.class);
        configuration.addAnnotatedClass(Image.class);
        configuration.addAnnotatedClass(Garage.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();

        return configuration.buildSessionFactory(serviceRegistry);
    }

    private static void initializeData() throws Exception {

        /* adding the garages */
        Garage majdGarage=new Garage("kafr kanna","051123581");
        Garage adamGarage=new Garage("tamra","051491625");
        session.save(majdGarage);
        session.save(adamGarage);
        session.flush();
        /* end of adding the garages */

        /*adding people*/
        Person majd=new Person("Majd","Abbas","011235813");
        Person adam=new Person("Adam","Ryan","149162536");

        session.save(majd);
        session.save(adam);
        session.flush();

        Person moutsfa=new Person("Moustfa","Jbareen","123456789");
        Person mohamed=new Person("Mohamed","hijazi","987654321");

        session.save(moutsfa);
        session.save(mohamed);
        session.flush();

        Person mohamed2=new Person("Mohamed","Jbareen","456123789");
        Person abdo=new Person("Abdo","Abbas","147852369");

        session.save(mohamed2);
        session.save(abdo);
        session.flush();

        Person messi=new Person("lionel","messi","999999999");
        Person ronaldo=new Person("cristiano","ronaldo","0000000000");
        session.save(messi);
        session.save(ronaldo);
        session.flush();
        /*end of adding people*/

        /*adding cars with images*/

        Car car1=new Car("12-333-12",500000,2023,majd);
        Image car1Img=new Image("https://www.caranddriver.com/mclaren/p1");
        car1Img.setCar(car1);
        car1.setImage(car1Img);
        majd.addCar(car1);

        session.save(majd);
        session.save(car1);
        session.save(car1Img);
        session.flush();

        Car car2=new Car("78-955-68",1000000,2023,adam);
        Image car2Img=new Image("https://pressroom.toyota.com/vehicle/2023-toyota-gr-supra/");
        car2Img.setCar(car2);
        car2.setImage(car2Img);
        adam.addCar(car2);

        session.save(adam);
        session.save(car2);
        session.save(car2Img);
        session.flush();

        Car car3=new Car("12-955-77",10000000,2023,moutsfa);
        Image car3Img=new Image("https://robbreport.com/motors/cars/mclarens-entry-level-sports-cars-are-anything-boring-230565/");
        car3Img.setCar(car3);
        car3.setImage(car3Img);
        moutsfa.addCar(car3);

        session.save(moutsfa);
        session.save(car3);
        session.save(car3Img);
        session.flush();

        Car car4=new Car("486-19-601",100000000,2023,mohamed);
        Image car4Img=new Image("https://abcnews.go.com/Business/electric-sports-cars-shockingly-fast-emissions-free-loyalists/story?id=78277579");
        car4Img.setCar(car4);
        car4.setImage(car4Img);
        mohamed.addCar(car4);

        session.save(mohamed);
        session.save(car4);
        session.save(car4Img);
        session.flush();

        Car car5=new Car(("500-50-500"),542000,2023,mohamed2);
        Image car5Img=new Image("https://cars.usnews.com/cars-trucks/chevrolet/corvette");
        car5Img.setCar(car5);
        car5.setImage(car5Img);
        mohamed2.addCar(car5);

        session.save(mohamed2);
        session.save(car5);
        session.save(car5Img);
        session.flush();

        Car car6=new Car(("999-99-999"),850000,2023,abdo);
        Image car6Img=new Image("https://www.caranddriver.com/subaru/brz");
        car6Img.setCar(car6);
        car6.setImage(car6Img);
        abdo.addCar(car6);

        session.save(abdo);
        session.save(car6);
        session.save(car6Img);
        session.flush();

        Car car7=new Car(("10-100-10"),600000,2023,messi);
        Image car7Img=new Image("https://www.caranddriver.com/tesla/model-s");
        car7Img.setCar(car7);
        car7.setImage(car7Img);
        messi.addCar(car7);

        session.save(messi);
        session.save(car7);
        session.save(car7Img);
        session.flush();

        Car car8=new Car(("00-000-00"),700000,2023,ronaldo);
        Image car8Img=new Image("https://www.webbikeworld.com/the-best-motorcycles-to-come-out-of-britain/");
        car8Img.setCar(car8);
        car8.setImage(car8Img);
        ronaldo.addCar(car8);

        session.save(ronaldo);
        session.save(car8);
        session.save(car8Img);
        session.flush();

        /*end of adding cars with images*/

        /*adding the cars and people to the garage*/
        majdGarage.addOwner(majd);
        adamGarage.addOwner(adam);
        session.save(majdGarage);
        session.save(adamGarage);
        session.flush();

        majd.addGarage(majdGarage);
        adam.addGarage(adamGarage);
        session.save(majd);
        session.save(adam);
        session.flush();

        car1.addGarge(majdGarage);
        car2.addGarge(majdGarage);
        majdGarage.addCar(car1);
        majdGarage.addCar(car2);
        session.save(car1);
        session.save(car2);
        session.save(majdGarage);
        session.flush();

        car3.addGarge(majdGarage);
        car4.addGarge(majdGarage);
        majdGarage.addCar(car3);
        majdGarage.addCar(car4);
        session.save(car3);
        session.save(car4);
        session.save(majdGarage);
        session.flush();

        car5.addGarge(adamGarage);
        car6.addGarge(adamGarage);
        adamGarage.addCar(car5);
        adamGarage.addCar(car6);
        session.save(car5);
        session.save(car6);
        session.save(adamGarage);
        session.flush();

        car7.addGarge(adamGarage);
        car8.addGarge(adamGarage);
        adamGarage.addCar(car7);
        adamGarage.addCar(car8);
        session.save(car7);
        session.save(car8);
        session.save(adamGarage);
        session.flush();

        /*end of adding the cars and people to the garage*/
        session.getTransaction().commit();
    }

    private static List<Car> getAllCars() throws Exception {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Car> query = builder.createQuery(Car.class);
        query.from(Car.class);
        List<Car> data = session.createQuery(query).getResultList();
        return data;
    }
    private static List<Garage> getAllGarges() throws Exception {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Garage> query = builder.createQuery(Garage.class);
        query.from(Garage.class);
        List<Garage> data = session.createQuery(query).getResultList();
        return data;
    }

    private static void printAllCars() throws Exception {
        List<Car> cars = getAllCars();
        System.out.println(GREEN_BOLD+"all of Cars:\n"+ANSI_RESET);
        for (Car car : cars) {
            System.out.println(car);
        }
    }
    private static void printAllGarages() throws Exception
    {
        List<Garage> garages = getAllGarges();
        System.out.println(GREEN_BOLD+"all of Garages:\n"+ANSI_RESET);
        for (Garage garage : garages) {
            System.out.println(garage);
        }
    }

    public static void main( String[] args ) {
        try {
            SessionFactory sessionFactory = getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();


            initializeData();

            printAllGarages();
            printAllCars();

          //  session.getTransaction().commit(); // Save everything.

        } catch (Exception exception) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            System.err.println("An error occured, changes have been rolled back.");
            exception.printStackTrace();
        } finally {
            session.close();
            session.getSessionFactory().close();
        }
    }
}