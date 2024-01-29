package ru.cast;

public class Main {
    public static void main(String[] args) {
        Vehicle airplane1 = new Airplane();
        Vehicle airplane2 = new Airplane();
        Vehicle train1 = new Train();
        Vehicle train2 = new Train();
        Vehicle bus1 = new Bus();
        Vehicle bus2 = new Bus();
        Vehicle[] vehicles = {airplane1, airplane2, train1, train2, bus1, bus2};

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getClass());
            vehicle.move();
            vehicle.fuelType();
        }
    }
}
