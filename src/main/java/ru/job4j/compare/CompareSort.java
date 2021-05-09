package ru.job4j.compare;

import ru.job4j.tracker.Item;

import java.util.*;

public class CompareSort {
    public static void main(String[] args) {

        List<Item> items = Arrays.asList(
                new Item("alex", 6),
                new Item("boris", 3),
                new Item("zevs", 4)
        );
        System.out.println("Изначальный лист");
        System.out.println(items);
        System.out.println("После сортировки по Айди");
        Collections.sort(items);
        System.out.println(items);
        System.out.println("После сортировки по Айди обратный порядок");
        Collections.sort(items, new CompareIdRevers());
        System.out.println(items);
        System.out.println("После сортировки по Нейму");
        Collections.sort(items, new CompareToName());
        System.out.println(items);
        System.out.println("После сортировки по Нейму обратный порядок");
        Collections.sort(items, new CompareNameRevers());
        System.out.println(items);
    }
}
