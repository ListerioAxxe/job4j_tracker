package ru.job4j.map;

import java.util.Map;

public class ComputeIfPresent {
    public static Map<Integer, String> collectData(
            Map<Integer, String> name, Map<Integer, String> surname) {
        for (var key : name.keySet()) {
            name.computeIfPresent(key, (keys, value) -> name.get(key) + " " + surname.get(key));
        }
        return name;
    }
}