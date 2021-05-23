package ru.job4j.test;

public class Validator {
    public static boolean checkArray(int[] data, int value) {
        int count = 0;
        for (var el : data) {
            if (el == value) {
                count++;
            }
            if (count >= data.length/2) {
                return false;
            }
        }
        return true;
    }
}