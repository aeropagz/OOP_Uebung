package Aufgabe2;

import java.util.Arrays;
import java.util.List;

public class Date {
    private static final List<Integer> longMonths = Arrays.asList(1, 3, 5, 7, 8, 10, 12);
    private static final List<Integer> shortMonths = Arrays.asList(4, 6, 9, 11);


    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.setDay(day).setMonth(month).setYear(year);
    }

    public boolean isUltimo() {

        if ((this.getDay() == 31) && longMonths.contains(this.getMonth())) {
            return true;
        } else if (this.getDay() == 31 && shortMonths.contains(this.getMonth())) {
            return true;
        } else if (this.getDay() == 29 && this.getMonth() == 2 && this.isLeapYear()) {
            return true;
        } else return this.getDay() == 28 && this.getMonth() == 2 && !this.isLeapYear();

    }

    public boolean isHoliday() {
        return isFixedHoliday() || isBirthday();
    }

    public boolean isBirthday() {
        return this.getMonth() == 9 && this.getDay() == 29;
    }

    public boolean isEaster() {

        // Eulersche equation
        int a = this.getYear() % 19;
        int b = this.getYear() % 4;
        int c = this.getYear() % 7;
        int k = this.getYear() / 100;
        int p = (8 * k + 13) / 25;
        int q = k / 4;
        int M = (15 + k - p - q) / 30;
        int d = (19 * a + M) % 30;
        int N = (4 + k - q) % 7;
        int e = (2 * b + 4 * c + 6 * d + N) % 7;
        int daysEastern = (22 + d + e); // days in March, 32th March => 1st April
        if (d == 29 && e == 6) {
            daysEastern = 50;
        } else if (d == 28 && e == 6 && a > 10) {
            daysEastern = 49;
        }

        if (daysEastern <= 31 && this.getMonth() == 3 && this.getDay() == daysEastern) {
            return true;
        } else return daysEastern > 31 && this.getMonth() == 4 && this.getDay() - 31 == daysEastern;
    }

    public boolean isFixedHoliday() {

        // new Year
        if (this.getMonth() == 1 && this.getDay() == 1) {
            return true;
        }
        // Day of Work
        if (this.getMonth() == 5 && this.getDay() == 1) {
            return true;
        }
        // Reunion Halloween(joke)
        if (this.getMonth() == 10 && (this.getDay() == 3 || this.getDay() == 31)) {
            return true;
        }
        // Christmas
        return this.getMonth() == 12 && (this.getDay() == 25 || this.getDay() == 26);
    }

    public boolean isLeapYear() {
        if (this.getYear() % 4 == 0) {
            if (this.getYear() % 100 == 0) {
                return this.getYear() % 400 == 0;
            }
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return String.format("%d.%d.%d", this.getDay(), this.getMonth(), this.getYear());
    }

    public Date setDate(int day, int month, int year) {
        this.setYear(year).setMonth(month).setDay(day);
        return this;
    }

    public int getMonth() {
        return month;
    }

    public Date setMonth(int month) {
        if (month > 0 && month <= 12) {
            this.month = month;
        } else {
            throw new IllegalArgumentException("Choose month between 1 and 12");
        }
        return this;
    }

    public int getYear() {
        return year;
    }

    public Date setYear(int year) {
        if (year > 0) {
            this.year = year;
        } else {
            throw new IllegalArgumentException("Choose positive Number for a year");
        }
        return this;
    }

    public int getDay() {
        return day;
    }

    public Date setDay(int day) {
        if (day > 0 && day <= 31) {
            this.day = day;
        } else {
            throw new IllegalArgumentException("Choose Day between 1 and 31");
        }
        return this;
    }
}
