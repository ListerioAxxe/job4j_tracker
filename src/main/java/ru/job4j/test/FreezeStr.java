package ru.job4j.test;

import java.util.*;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        Map<String, Integer> f = new HashMap<>();
        Map<String, Integer> s = new HashMap<>();
        for (var el : left.split("")) {
            f.putIfAbsent(el, 1);
            f.computeIfPresent(el, (k, v) -> v + 1);
        }
        for (var el : right.split("")) {
            s.putIfAbsent(el, 1);
            s.computeIfPresent(el, (k, v) -> v + 1);
        }
        return f.equals(s);
    }
}