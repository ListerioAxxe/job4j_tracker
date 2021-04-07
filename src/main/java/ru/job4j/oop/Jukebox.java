package ru.job4j.oop;

public class Jukebox {

    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюжи");
        }
        else if (position == 2) {
            System.out.println("спокойной ночи");
        }
        else {
            System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        Jukebox song = new Jukebox();
        song.music(5);
    }
}
