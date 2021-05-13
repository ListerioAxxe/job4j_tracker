package ru.job4j.list;

import java.util.Iterator;
import java.util.List;

public class IteratorForList {
    public static void main(String[] args) {
       int[] arra = {1, 2, 3, 4};
       arra[-1] = 1;
        System.out.println(arra);
    }
}