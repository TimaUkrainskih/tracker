package ru.cast;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Автобус двигается по скоростным трассам");
    }

    @Override
    public void fuelType() {
        System.out.println("Дизельное топливо");
    }
}