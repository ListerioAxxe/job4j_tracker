package ru.job4j.test;

import java.util.List;

public class ReductionWithTwoArguments {
    public static Integer collect(List<Integer> list) {
        return list.stream().reduce(1, (x, y) -> y * 5);
    }
}