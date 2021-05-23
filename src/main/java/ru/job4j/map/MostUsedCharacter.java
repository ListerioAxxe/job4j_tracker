package ru.job4j.map;

import java.util.*;

/**
 * создаем карту чаров и интеджеров
 * приводим сстроку к нижнему регистру
 * убираем из нее пробелы
 * переводим в масив чаров
 * ппроходим по массиву, собираем карту
 * если ключ такой уже есть, то добавляем к его значению +1
 * если нет, то добавляем его со значением 0
 * проходимся по ключам, если значение больше 0, то присваиваем ключ
 * и присваиваем значение этого ключа
 */

public class MostUsedCharacter {
    public static char getMaxCount(String str) {
        Map<Character, Integer> letters = new HashMap<>();
        str = str.toLowerCase();
        str = str.replaceAll("\\s+", "");
        char[] chars = str.toCharArray();
        char rsl = ' ';
        int counter = 0;
        for (char letter : chars) {
            letters.computeIfPresent(letter, (key, value) -> value + 1);
            letters.putIfAbsent(letter, 0);
        }
        for (char key : letters.keySet()) {
            if (letters.get(key) > counter) {
                rsl = key;
                counter = letters.get(key);
            }
        }
        return rsl;
    }
}