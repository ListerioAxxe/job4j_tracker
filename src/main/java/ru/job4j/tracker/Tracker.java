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
        for (int i = 0; i < size; i++) {
           if (items[i] != null ) {
               findAllItems[rsl++] = items[i];
           }
        }
        findAllItems = Arrays.copyOf(findAllItems, rsl);
        return findAllItems;
    }

    public Item[] findByName(String key) {
        return Arrays.copyOf(items, size);
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int idIndex = indexOf(id);
        if (idIndex != -1) {
            item.setId(id);
            items[idIndex] = item;
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
       int itemDelete = indexOf(id);
            if (items[itemDelete] != null ) {
                System.arraycopy(items, itemDelete+1, items, itemDelete, size-itemDelete - 1);
                items[size-1] = null;
                size--;
                return true;
            }
        return false;
    }


}