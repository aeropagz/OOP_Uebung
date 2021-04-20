package Aufgabe3.vehicle;

import Aufgabe3.motor.Motor;

public class Car extends Vehicle {
    public String color;

    public Car(final String manufacturer, final String model, final int weight, final int constructionYear,
               final int maxSpeed, final Motor motor, final String color) {
        super(manufacturer, model, weight, constructionYear, maxSpeed, motor);
        this.setColor(color);
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                "}\n" + super.toString();
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
