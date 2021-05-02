package ru.job4j.tracker;

public class ConsoleOutput implements Output {
    @Override
    public void println(String string) {
        System.out.println(string);
    }
}