package ru.job4j.list;

import java.util.List;

public class UniqueElement {
    public static boolean checkList(List<String> list, String str) {
        int first = list.indexOf(str);
        int last = list.lastIndexOf(str);
        if (first == last && list.contains(str)) {
            return true;
        }
        return false;
    }
}