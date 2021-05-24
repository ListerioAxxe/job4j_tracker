package ru.job4j.map;

import java.util.*;

public class Concordance {
    public static Map<Character, List<Integer>> collectCharacters(String s) {
        Map<Character, List<Integer>> rslt = new HashMap<>();
        s = s.replaceAll("\\s", "");
        char[] s1 = s.toCharArray();
        for (int i = 0; i < s1.length; i++) {
          rslt.putIfAbsent(s1[i], new ArrayList<>());
          rslt.get(s1[i]).add(i);
        }
        return rslt;
    }
}