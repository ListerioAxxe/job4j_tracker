package ru.job4j.Compare;

import ru.job4j.tracker.Item;

import java.util.Comparator;

public class CompareToName implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
  class CompareNameReverse implements Comparator<Item> {

      @Override
      public int compare(Item o1, Item o2) {
          return o2.getName().compareTo(o1.getName());
      }
  }

      class CompareIdReverse implements Comparator<Item> {
          @Override
          public int compare(Item o1, Item o2) {
              return o2.getId() - o1.getId();
          }
  }
