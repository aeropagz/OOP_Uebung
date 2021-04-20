package Aufgabe3.vehicle;

import Aufgabe3.motor.Motor;

public class Bus extends Vehicle {
    private int childseats;

    public Bus(final String manufacturer, final String model, final int weight, final int constructionYear,
               final int maxSpeed, final Motor motor, final int childseats) {
        super(manufacturer, model, weight, constructionYear, maxSpeed, motor);
        this.setChildseats(childseats);

    }

    @Override
    public String toString() {
        return "Bus:\n" +
                "childseats=" + childseats +
                "\n" + super.toString();
    }

    public int getChildseats() {
        return this.childseats;
    }

    public void setChildseats(int childseats) {
        this.childseats = childseats;
    }
}
