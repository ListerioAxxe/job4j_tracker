package ru.job4j.test;

import ru.job4j.tracker.StubOutput;

import java.util.Optional;

public class Optional4 {

    public static void ifPresent(int[] data) {
        max(data).ifPresent(x -> System.out.println("Max :" + x));
    }

    private static Optional<Integer> max(int[] data) {
        if (data.length != 0) {
        int max = data[0];
        for (int i = 0; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
            return Optional.of(max);
        }
        return Optional.empty();
    }
}
