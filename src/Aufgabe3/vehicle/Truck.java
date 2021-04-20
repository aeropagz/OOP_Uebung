package Aufgabe3.vehicle;

import Aufgabe3.motor.Motor;

import java.util.ArrayList;

public class Truck extends Vehicle {
    private ArrayList<String> load;

    public Truck(final String manufacturer, final String model, final int weight, final int constructionYear,
                 final int maxSpeed, final Motor motor) {
        super(manufacturer, model, weight, constructionYear, maxSpeed, motor);
        this.load = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Truck:\n" +
                "load=" + load +
                "\n" + super.toString();
    }

    public ArrayList<String> getLoad() {
        return load;
    }

    public void setLoad(ArrayList<String> load) {
        this.load = load;
    }
}
