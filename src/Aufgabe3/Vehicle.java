package Aufgabe3;

public class Vehicle {
    private String manufacturer;
    private String model;
    private int weight;
    private int constructionYear;
    private int maxSpeed;

    public Vehicle(String manufacturer, String model, int weight, int constructionYear, int maxSpeed) {
        this.setManufacturer(manufacturer).setModel(model).setWeight(weight).setConstructionYear(constructionYear)
                .setMaxSpeed(maxSpeed);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public final Vehicle setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public String getModel() {
        return model;
    }

    public final Vehicle setModel(String model) {
        this.model = model;
        return this;
    }

    public int getWeight() {
        return weight;
    }

    public final Vehicle setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    public int getConstructionYear() {
        return constructionYear;
    }

    public final Vehicle setConstructionYear(int constructionYear) {
        this.constructionYear = constructionYear;
        return this;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public final Vehicle setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
        return this;
    }
}
