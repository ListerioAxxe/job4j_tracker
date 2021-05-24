package ru.job4j.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {
    public static Map<String, List<String>> collectData(String[] strings) {
        Map<String, List<String>> rsl = new HashMap<>();
        for (var el : strings) {
          String firstChar = String.valueOf(el.charAt(0));
          rsl.putIfAbsent(firstChar, new ArrayList<>());
          rsl.get(firstChar).add(el);
        }
        return rsl;
    }
}