package Aufgabe1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void consumeFavoriteMeal() {
        Person me  = new Person("Pelzer", "Klaas", 102, 10, 100);
        me.consumeFavoriteMeal();
        assertEquals(105, me.getWeight());
        assertEquals(10, me.getMood());
    }

    @Test
    void consumeUnhealthyMeal() {
    }

    @Test
    void consumeHealthyMeal() {
    }
}