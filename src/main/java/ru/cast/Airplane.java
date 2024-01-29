package ru.cast;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println("Самолет летает по воздуху");
    }

    @Override
    public void fuelType() {
        System.out.println("Керосин или авиационный бензин");
    }
}