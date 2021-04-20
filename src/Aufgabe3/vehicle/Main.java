package Aufgabe3.vehicle;

import Aufgabe1.Person;
import Aufgabe2.Date;
import Aufgabe3.motor.Motor;

public class Main {

    public static void main(String[] args) {
        Person owner = new Person("Pelzer", "Klaas", 100, 10, 100,
                new Date(29, 9, 1995));
        Driver driver = new Driver("Petersen", "Nico", 100, 10, 100,
                new Date(29, 9, 1995));

        driver.setAllowedToDrive(true);

        Motor motor = new Motor(990, 8, 120, "Bölkstoff", 200);

        Bus bus = new Bus("VW", "Transporter", 2000, 2001, 120,
                motor, 200);
        bus.setDriver(driver);
        bus.setOwner(owner);
        System.out.println(bus);

        Tank panzer = new Tank("Rheinmetall", "Tiger", 2000, 2001, 9000,
                motor, 5);
        panzer.setDriver(driver);
        panzer.setOwner(owner);
        System.out.println(panzer);

        Motorcycle bike = new Motorcycle("VW", "Transporter", 2000, 2001, 120,
                motor, "Moped");
        bike.setDriver(driver);
        bike.setOwner(owner);
        System.out.println(bike);


    }
}
