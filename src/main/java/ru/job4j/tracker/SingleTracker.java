package ru.job4j.tracker;

import java.util.List;

public final class SingleTracker {
    private static SingleTracker instance = null;
    private MemTracker tracker = new MemTracker();

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public boolean delete(int id) {
         return tracker.delete(id);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public List<Item> findByName(String key) {
        return tracker.findByName(key);
    }

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    public List<Item> findAll() {
        return tracker.findAll();
    }
}