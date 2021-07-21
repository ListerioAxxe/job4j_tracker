package ru.job4j.tracker;

import java.util.List;

public class ShowAllItem implements UserAction {
    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Store tracker, Output out) {
        List<Item> find = tracker.findAll();
        for (Item item : find) {
            out.println(item.toString());
            }
        return true;
    }
}
