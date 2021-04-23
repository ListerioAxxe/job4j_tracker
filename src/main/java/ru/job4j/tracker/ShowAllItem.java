package ru.job4j.tracker;

import java.util.Arrays;

public class ShowAllItem implements UserAction{
    @Override
    public String name() {
        return "1. Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] find = tracker.findAll();
        System.out.println(Arrays.toString(find));
        return true;
    }
}
