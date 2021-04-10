package ru.job4j.oop;

public class Story {
    public static void main(String[] args) {
        Peoneer petya = new Peoneer();
        Girl girl = new Girl();
        Wolf1 wolf = new Wolf1();
        girl.help(petya);
        wolf.kill(girl);
        petya.kill(wolf);
    }
}
