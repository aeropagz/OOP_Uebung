package Aufgabe3;

public class Motor {
    private int displacement;
    private int cylinder;
    private int power;
    private String fuel;
    private int weight;

    public Motor(int displacement, int cylinder, int power, String fuel, int weight) {
        this.setDisplacement(displacement).setCylinder(cylinder).setPower(power).setFuel(fuel).setWeight(weight);
}

    public int getDisplacement() {
        return displacement;
    }

    public final Motor setDisplacement(int displacement) {
        this.displacement = displacement;
        return this;
    }

    public int getCylinder() {
        return cylinder;
    }

    public final Motor setCylinder(int cylinder) {
        this.cylinder = cylinder;
        return this;
    }

    public int getPower() {
        return power;
    }

    public final Motor setPower(int power) {
        this.power = power;
        return this;
    }

    public String getFuel() {
        return fuel;
    }

    public final Motor setFuel(String fuel) {
        this.fuel = fuel;
        return this;
    }

    public int getWeight() {
        return weight;
    }

    public final Motor setWeight(int weight) {
        this.weight = weight;
        return this;
    }
}
