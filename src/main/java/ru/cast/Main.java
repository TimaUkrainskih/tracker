package ru.cast;

public class Main {
    public static void main(String[] args) {
        Airplane airplane1 = new Airplane();
        Airplane airplane2 = new Airplane();
        Train train1 = new Train();
        Train train2 = new Train();
        Bus bus1 = new Bus();
        Bus bus2 = new Bus();
        Vehicle[] vehicles = {airplane1, airplane2, train1, train2, bus1, bus2};
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getClass());
            vehicle.move();
            vehicle.fuelType();
        }
    }
}
