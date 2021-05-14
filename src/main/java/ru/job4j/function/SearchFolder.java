package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFolder {

    public static List<Folder> filter(List<Folder> list, Predicate<Folder> pred) {
        List<Folder> rsl = new ArrayList<>();
        for (Folder folders : list) {
            if (pred.test(folders)) {
                rsl.add(folders);
            }
        }
        return rsl;
    }
}