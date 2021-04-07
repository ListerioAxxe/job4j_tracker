package ru.job4j.oop;

import java.lang.reflect.Field;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void output() {
        System.out.println(active);
        System.out.println(status);
        System.out.println(message);
        System.out.println();
    }

    public static void main(String[] args) {
        Error first = new Error();
        Error second = new Error(true, 1, "Is Work");
        Error third = new Error(false, 2, "Dont Work");
        first.output();
        second.output();


    }
}
