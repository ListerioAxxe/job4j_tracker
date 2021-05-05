package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class SubList {
    public static List<String> getElementsBetweenIndexes(List<String> list, String el) {
            int firstInd = list.indexOf(el);
            int lastInd = list.lastIndexOf(el);
            ArrayList<String> first = new ArrayList<>(list.subList(firstInd, lastInd));

        return first;
        }
}