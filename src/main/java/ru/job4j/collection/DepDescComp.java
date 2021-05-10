package ru.job4j.collection;

import java.lang.reflect.Array;
import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] start = o1.split("/");
        String[] end = o2.split("/");
        return end[0].compareTo(start[0]);
    }
}