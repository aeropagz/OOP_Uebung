package Aufgabe1;

import java.util.UUID;

public class Person {
    private final UUID id = UUID.randomUUID();
    private String name = "";
    private String firstname = "";
    private int weight = 75;
    private int mood = 8;
    private int health = 90;

    public Person( String name, String firstname, int weight, int mood, int health) {
        this.setName(name);
        this.setFirstname(firstname);
        this.setWeight(weight);
        this.setMood(mood);
        this.setHealth(health);
    }

    public Person(Person person) {
        this.setName(person.getName());
        this.setFirstname(person.getFirstname());
        this.setWeight(person.getWeight());
        this.setMood(person.getMood());
        this.setHealth(person.getHealth());
    }

    private static int clamp(int min, int max, int value) {
        return Math.min(Math.max(value, min), max);
    }

    public Person consumeFavoriteMeal() {
        this.setMood(this.getMood() + 2);
        this.setHealth(this.getHealth() + 3);
        this.setWeight(this.getWeight() + 3);
        return this;
    }

    public Person consumeUnhealthyMeal() {
        this.setMood(this.getMood() - 3);
        this.setHealth(this.getHealth() - 5);
        this.setWeight(this.getWeight() + 5);
        return this;
    }

    public Person consumeHealthyMeal() {
        this.setMood(this.getMood() - 5);
        this.setHealth(this.getHealth() + 5);
        return this;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public Person setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public int getWeight() {
        return weight;
    }

    public Person setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    public int getMood() {
        return mood;
    }

    public Person setMood(int mood) {
        this.mood = clamp(0, 10, mood);
        return this;
    }

    public int getHealth() {
        return health;
    }

    public Person setHealth(int health) {
        this.health = clamp(0, 100, health);
        return this;
    }
}
