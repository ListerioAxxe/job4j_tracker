package ru.job4j.oop;

public class Buss implements Vehicle {


    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + "  move intro the Road ");
    }

}
