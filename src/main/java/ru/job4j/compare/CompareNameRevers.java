package ru.job4j.compare;

import ru.job4j.tracker.Item;

import java.util.Comparator;

public class CompareNameRevers implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        return o2.getName().compareTo(o1.getName());
    }
}