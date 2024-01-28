package ru.poly;

public interface Transport {
    void drive();

    void passengers(int countPassengers);

    double fill(double fuel);
}
