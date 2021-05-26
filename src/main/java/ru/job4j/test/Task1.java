package ru.job4j.test;

import java.util.List;
import java.util.stream.Collectors;

public class Task1 {
    public static List<String> changePosition(List<String> list, int index) {
        if (index >= 0 && index < list.size()) {
            String s = list.remove(index);
            list.set(index, s);
        }
        return list;
    }
}

