package Aufgabe3.vehicle;

import Aufgabe3.motor.Motor;

public class Motorcycle extends Vehicle {
    private String type;

    public Motorcycle(final String manufacturer, final String model, final int weight, final int constructionYear,
                      final int maxSpeed, final Motor motor, String type) {
        super(manufacturer, model, weight, constructionYear, maxSpeed, motor);
        this.setType(type);
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Motorcycle:\n" +
                "type='" + type + '\'' +
                "\n" + super.toString();
    }
}
