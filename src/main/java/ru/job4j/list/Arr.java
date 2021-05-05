package ru.job4j.list;

public class Arr {
    public static char[] toUpperCase(char[] string) {
        char[] rse = new char[string.length];
       String str = new String(string);
       String rsl = str.toUpperCase();
        for (int i = 0; i < string.length; i++) {
            rse[i] = rsl.charAt(i);
        }
        return rse;
    }
}