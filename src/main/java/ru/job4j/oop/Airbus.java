package ru.job4j.oop;

public class Airbus implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + "  move intro the Air ");
    }

}
