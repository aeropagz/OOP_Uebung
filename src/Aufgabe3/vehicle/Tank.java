package Aufgabe3.vehicle;

import Aufgabe3.motor.Motor;

public class Tank extends Vehicle {
    private int ammo;


    public Tank(final String manufacturer, final String model, final int weight, final int constructionYear,
                final int maxSpeed, final Motor motor, final int ammo) {
        super(manufacturer, model, weight, constructionYear, maxSpeed, motor);
        this.setAmmo(ammo);
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(final int ammo) {
        this.ammo = ammo;
    }

    @Override
    public String toString() {
        return "Tank:\n" +
                "ammo=" + ammo +
                "\n" + super.toString();
    }
}
