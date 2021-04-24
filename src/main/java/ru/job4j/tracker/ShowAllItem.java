package ru.job4j.tracker;

import java.util.Arrays;

public class ShowAllItem implements UserAction {
    private final Output out;

    public ShowAllItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] find = tracker.findAll();
        out.println(Arrays.toString(find));
        return true;
    }
}
