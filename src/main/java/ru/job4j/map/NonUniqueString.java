package ru.job4j.map;

import java.util.HashMap;
import java.util.Map;

/**
 * из массива стрингов собираем карту
 * проходимся по массиву
 * rsl.computeIfPresent(string, (key, value) -> true); - строка встречается уже такая, то true
 * rsl.putIfAbsent(string, false); - если строки нет, то добавляем в карту, и false
 */

public class NonUniqueString {
    public static Map<String, Boolean> checkData(String[] strings) {
        Map<String, Boolean> rsl = new HashMap<>();
        for (var string : strings) {
          rsl.computeIfPresent(string, (key, value) -> true);
          rsl.putIfAbsent(string, false);
        }
        return rsl;
    }
}