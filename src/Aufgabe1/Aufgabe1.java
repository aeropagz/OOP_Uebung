package Aufgabe1;

import Aufgabe2.Date;

public class Aufgabe1 {
    public static void main(String[] args) {
        Person klaas = new Person("Pelzer", "Klaas", 100, 10, 100,
                new Date(29, 9, 1995));
        System.out.println("Homeless: " + klaas.isHomeless());
        klaas.move(new Adresse("Boiestraße", 3, 24114, "Kiel"), new Date(9, 4, 2021));
        klaas.move(new Adresse("Boiestraße", 4, 24114, "Kiel"), new Date(10, 4, 2021));
        klaas.move(new Adresse("Boiestraße", 5, 24114, "Kiel"), new Date(11, 4, 2021));
        klaas.move(new Adresse("Boiestraße", 6, 24114, "Kiel"), new Date(12, 4, 2021));
        klaas.printAddressHistory();
    }
}
