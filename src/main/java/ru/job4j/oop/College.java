package ru.job4j.oop;

public class College {
    public static void main(String[] args) {
        Freshman freshman = new Freshman();
        Student stuFresh = freshman;
        Object objFresh = freshman;

        //или

        Student first = new Freshman();
        Object obj = new Freshman();

    }
}
