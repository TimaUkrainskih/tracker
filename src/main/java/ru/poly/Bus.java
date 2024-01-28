package ru.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Автобус едет");
    }

    @Override
    public void passengers(int countPassengers) {
        System.out.println("В автобусе " + countPassengers + " пассажиров");
    }

    @Override
    public double fill(double fuel) {
        double price = 2.5;
        return fuel * price;
    }
}
