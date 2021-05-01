package ru.job4j.tracker;

import java.util.Arrays;

public final class SingleTracker {
    private Tracker tracker = new Tracker();
    private static SingleTracker instance = null;

    private SingleTracker() {
    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public Item delete(int id) {
        return null;
    }

    public Item replace(int id, Item item) {
        return null;
    }

    public Item findByName(String key) {
        return null;
    }

    public Item findAll() {
        return null;
    }


}