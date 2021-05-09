package ru.job4j.collection;

import ru.job4j.list.Arr;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] l = left.split("\\.");
        String[] r = right.split("\\.");
        return Integer.compare(Integer.parseInt(l[0]), Integer.parseInt(r[0]));
    }

}