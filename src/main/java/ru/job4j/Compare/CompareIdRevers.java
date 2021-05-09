package ru.job4j.Compare;


import ru.job4j.tracker.Item;

import java.util.Comparator;

public class CompareIdRevers implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return Integer.compare(o2.getId(), o1.getId());
    }
}