package Aufgabe2;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @org.junit.jupiter.api.Test
    void isBirthday() {
        Date birthday = new Date(29, 9, 1996);
        assertTrue(birthday.isBirthday());
        birthday = new Date(20, 9, 1994);
        assertFalse(birthday.isBirthday());
    }

    @org.junit.jupiter.api.Test
    void isLeapYear() {
        Date leapYear = new Date(1, 2, 2020);
        assertTrue(leapYear.isLeapYear());
        leapYear.setDate(29, 9, 2021);
        assertFalse(leapYear.isLeapYear());
    }

    @org.junit.jupiter.api.Test
    void isUltimo() {
        Date ultimo = new Date(31, 3, 2004);
        assertTrue(ultimo.isUltimo());
        ultimo.setDate(29, 2, 2020);
        assertTrue(ultimo.isUltimo());
        ultimo.setDate(2, 4, 2001);
        assertFalse(ultimo.isUltimo());
    }
}