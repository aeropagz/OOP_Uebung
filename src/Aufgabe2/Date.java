package Aufgabe2;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Date {
    private static final List<Integer> longMonths = Arrays.asList(1, 3, 5, 7, 8, 10, 12);
    private static final List<Integer> shortMonths = Arrays.asList(4, 6, 9, 11);


    private int day;
    private int month;
    private int year;

    public Date(final int day, final int month, final int year) {
        this.setMonth(month).setYear(year).setDay(day);
    }

    public Date(final Date date){
        this(date.getDay(), date.getMonth(), date.getYear());
    }

    public static Date getEasterDate(final int year) {
        // Eulersche equation
        int a = year % 19;
        int b = year % 4;
        int c = year % 7;
        int k = year / 100;
        int p = (8 * k + 13) / 25;
        int q = k / 4;
        int M = (15 + k - p - q) % 30;
        int d = (19 * a + M) % 30;
        int N = (4 + k - q) % 7;
        int e = (2 * b + 4 * c + 6 * d + N) % 7;
        int daysEaster = (22 + d + e); // days in March, 32th March => 1st Aprilyear
        if (daysEaster <= 31) {
            return new Date(daysEaster, 3, year);
        } else {
            return new Date(daysEaster - 31, 4, year);
        }
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
        return this.isFixedHoliday() || this.isBirthday() || this.isEaster();
    }

    public boolean isBirthday() {
        return this.getMonth() == 9 && this.getDay() == 29;
    }

    public boolean isEaster() {
        return this.equals(getEasterDate(this.getYear()));
    }

    public boolean isPentecost() {
        Date easter = getEasterDate(this.getYear());
        int day = easter.getDay() + 49;
        int month = easter.getMonth();
        while (day > (longMonths.contains(month) ? 31 : 30)) {
            day -= longMonths.contains(month) ? 31 : 30;
            month++;
        }
        return this.getDay() == day && this.getMonth() == month;
    }

    public boolean isAscension() {
        Date easter = getEasterDate(this.getYear());
        int day = easter.getDay() + 39;
        int month = easter.getMonth();
        while (day > (longMonths.contains(month) ? 31 : 30)) {
            day -= longMonths.contains(month) ? 31 : 30;
            month++;
        }
        return this.getDay() == day && this.getMonth() == month;
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

    public final Date setMonth(int month) {
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

    public final Date setYear(int year) {
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

    public final Date setDay(int day) {
        if (day > 0 && day <= 31) {
            if(!(this.getMonth() == 2 && ((day <=29 && this.isLeapYear()) || (!this.isLeapYear() && day <=28))))
                this.day = day;
        } else
            {
            throw new IllegalArgumentException("Choose Day between 1 and 31");
        }
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Date)) return false;
        Date date = (Date) o;
        return getDay() == date.getDay() && getMonth() == date.getMonth() && getYear() == date.getYear();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDay(), getMonth(), getYear());
    }
}
