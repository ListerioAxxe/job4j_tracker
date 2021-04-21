package ru.job4j.oop;

public class VehicleTest {
    public static void main(String[] args) {
        Vehicle airbus = new Airbus();
        Vehicle bus = new Buss();
        Vehicle train = new Train();
        Vehicle[] result = new Vehicle[]{airbus, bus, train};
        for (Vehicle vehicles: result) {
           vehicles.move();
        }
    }
}
