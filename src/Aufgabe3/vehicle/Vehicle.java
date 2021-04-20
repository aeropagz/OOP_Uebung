package Aufgabe3.vehicle;

import Aufgabe1.Person;
import Aufgabe3.motor.Motor;

public class Vehicle {
    private String manufacturer;
    private String model;
    private int weight;
    private int constructionYear;
    private int maxSpeed;
    private Person owner;
    private Driver driver;
    private Motor motor;

    public Vehicle(String manufacturer, String model, int weight, int constructionYear, int maxSpeed, Motor motor) {
        this.setManufacturer(manufacturer).setModel(model).setWeight(weight).setConstructionYear(constructionYear)
                .setMaxSpeed(maxSpeed).setMotor(motor);
    }

    public Motor getMotor() {
        return motor;
    }

    public final Vehicle setMotor(final Motor motor) {
        this.motor = motor;
        return this;
    }

    public Driver getDriver() {
        return driver;
    }

    public final Vehicle setDriver(final Driver driver) {
        this.driver = driver;
        return this;
    }

    public Person getOwner() {
        return owner;
    }

    public final Vehicle setOwner(final Person owner) {
        this.owner = owner;
        return this;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public final Vehicle setManufacturer(final String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public String getModel() {
        return model;
    }

    public final Vehicle setModel(final String model) {
        this.model = model;
        return this;
    }

    public int getWeight() {
        return weight;
    }

    public final Vehicle setWeight(final int weight) {
        this.weight = weight;
        return this;
    }

    public int getConstructionYear() {
        return constructionYear;
    }

    public final Vehicle setConstructionYear(final int constructionYear) {
        this.constructionYear = constructionYear;
        return this;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public final Vehicle setMaxSpeed(final int maxSpeed) {
        this.maxSpeed = maxSpeed;
        return this;
    }

    @Override
    public String toString() {
        return  "manufacturer='" + manufacturer + '\'' +
                ",\nmodel='" + model + '\'' +
                ",\nweight=" + weight +
                ",\nconstructionYear=" + constructionYear +
                ",\nmaxSpeed=" + maxSpeed +
                ",\nowner=" + owner +
                ",\ndriver=" + driver +
                '\n';
    }
}
