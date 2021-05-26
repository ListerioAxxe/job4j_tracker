package ru.job4j.test;

import java.util.Comparator;
import java.util.List;

public class MinMethod {
    public static String min(List<String> list) {
        return list.stream().min((f1, f2) -> Integer.compare(f1.length(), f2.length())).get();
    }
}