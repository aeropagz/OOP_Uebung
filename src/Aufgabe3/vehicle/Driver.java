package Aufgabe3.vehicle;

import Aufgabe1.Person;
import Aufgabe2.Date;

public class Driver extends Person {

    @Override
    public String toString() {
        return "Driver{" +
                "allowedToDrive=" + allowedToDrive +
                "}\n" + super.toString();
    }

    private boolean allowedToDrive = false;

    public Driver(final String name, final String firstname, final int weight, final int mood, final int health,
                  final Date geburtsdatum) {
        super(name, firstname, weight, mood, health, geburtsdatum);
    }

    public Driver(Person person) {
        super(person);
    }

    public boolean isAllowedToDrive() {
        return allowedToDrive;
    }

    public final Driver setAllowedToDrive(final boolean allowedToDrive) {
        this.allowedToDrive = allowedToDrive;
        return this;
    }
}
