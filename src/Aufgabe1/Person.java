package Aufgabe1;

import Aufgabe2.Date;

import java.util.*;

public class Person {

    public static AdressContainer addresses = new AdressContainer();

    private final UUID id = UUID.randomUUID();
    private final Person[] parents = new Person[2];
    private final Person[] grandparents = new Person[4];
    private final List<Person> children = new ArrayList<Person>();
    private final List<Person> grandchildren = new ArrayList<Person>();
    private final HashMap<Date, Adresse> addressHistory = new HashMap<Date, Adresse>();

    // Aufgabe 2.1 neue Attribute
    private String name = "";
    private String firstname = "";
    private int weight = 75;
    private int mood = 8;
    private int health = 90;
    private Date geburtsdatum;
    private boolean alive;
    private Adresse address = null;
    private Date lastMovement = null;

    public Person(final String name, final String firstname, final int weight, final int mood, final int health,
                  final Date geburtsdatum) {
        this.setName(name);
        this.setFirstname(firstname);
        this.setWeight(weight);
        this.setMood(mood);
        this.setHealth(health);
        this.setGeburtsdatum(geburtsdatum);
        this.setAlive(true);
    }

    public Person(final Person person) {
        this.setName(person.getName());
        this.setFirstname(person.getFirstname());
        this.setWeight(person.getWeight());
        this.setMood(person.getMood());
        this.setHealth(person.getHealth());
        this.setGeburtsdatum(person.getGeburtsdatum());
    }

    private static int clamp(int min, int max, int value) {
        return Math.min(Math.max(value, min), max);
    }

    private static boolean insertToArray(final Person[] personArray, final Person person) {
        boolean inserted = false;
        for (int i = 0; i < personArray.length; i++) {
            if (personArray[i] == null) {
                personArray[i] = person;
                inserted = true;
                break;
            }
        }
        return inserted;
    }

    public final Person addParent(final Person parent) throws Exception {
        if (!insertToArray(this.getParents(), parent)) {
            throw new Exception("(Grand-)Parents already full");
        }
        return this;
    }

    public void addParents(final Person parent1, final Person parent2) throws Exception {
        this.addParent(parent1);
        this.addParent(parent2);
    }

    public final Person addGrandparent(final Person grandparent) throws Exception {
        if (!insertToArray(this.getGrandparents(), grandparent)) {
            throw new Exception("Grandparents already full");
        }
        return this;
    }

    public final Person died() {
        this.setAlive(false);
        return this;
    }


    public boolean isHomeless() {
        return this.getAddress() == null;
    }

    public final Person move(final Adresse newAdress, final Date movementDate) {
        this.setAddress(newAdress).setLastMovement(movementDate);
        this.addressHistory.put(this.getLastMovement(), this.getAddress());
        return this;
    }

    public final Person printAddressHistory() {
        for (Map.Entry<Date, Adresse> entry : this.getAddressHistory().entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        return this;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getId().equals(person.getId()) && getName().equals(person.getName()) && getFirstname()
                .equals(person.getFirstname()) && getGeburtsdatum().equals(person.getGeburtsdatum());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getFirstname(), getGeburtsdatum());
    }

    public Adresse getAddress() {
        return address;
    }

    private final Person setAddress(final Adresse address) {
        if (addresses.has(address)) {
            for (Adresse a : addresses.getAdressen()) {
                if (address.vergleiche(a)) {
                    this.address = a;
                }
            }
        } else {
            this.address = new Adresse(address.getStrasse(), address.getHnr(), address.getPLZ(), address.getStadt());
            addresses.insert(this.address);
        }
        return this;
    }

    public Date getLastMovement() {
        return lastMovement;
    }

    private final Person setLastMovement(final Date movementDate) {
        this.lastMovement = new Date(movementDate);
        return this;
    }

    public Person[] getParents() {
        return parents;
    }

    public Person[] getGrandparents() {
        return grandparents;
    }

    public List<Person> getChildren() {
        return children;
    }

    public List<Person> getGrandchildren() {
        return grandchildren;
    }

    public HashMap<Date, Adresse> getAddressHistory() {
        return addressHistory;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Date getGeburtsdatum() {
        return geburtsdatum;
    }

    private void setGeburtsdatum(Date geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
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
