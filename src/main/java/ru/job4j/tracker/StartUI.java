package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
      Tracker tracker = new Tracker();
      Item item = new Item();
      tracker.add(item);
      Item rsl = tracker.findById(5);
        System.out.println(rsl);
    }
}
