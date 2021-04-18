package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] findAllItems = new Item[size];
        int rsl = 0;
        for (int i = 0; i < findAllItems.length; i++) {
           if (findAllItems[i] != null ) {
               findAllItems[rsl++] = findAllItems[i];
           }
        }
        findAllItems = Arrays.copyOf(findAllItems, rsl);
        return findAllItems;
    }

    public Item[] findByName(String key) {
        Item[] findAllNames = new Item[size];
        int rsl = 0;
        for (int i = 0; i < findAllNames.length; i++) {
            if (key.equals(findAllNames[i].getName()) ) {
                findAllNames[rsl++] = findAllNames[i];
            }
        }
        findAllNames = Arrays.copyOf(findAllNames, rsl);
        return findAllNames;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }


}