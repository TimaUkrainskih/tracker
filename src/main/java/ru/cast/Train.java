package ru.cast;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Поезд передвигается по рельсам");
    }

    @Override
    public void fuelType() {
        System.out.println("Дизельное топливо или газовые турбины");
    }
}