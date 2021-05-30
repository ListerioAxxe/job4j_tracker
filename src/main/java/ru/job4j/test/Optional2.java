package ru.job4j.test;

import java.util.Optional;

public class Optional2 {

    public static int get(int[] data, int el) {
        return indexOf(data, el).isPresent() ? indexOf(data, el).get() : -1;
    }

    private static Optional<Integer> indexOf(int[] data, int el) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == el) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }
}