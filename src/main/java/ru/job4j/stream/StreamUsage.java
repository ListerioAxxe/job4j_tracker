package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static void main(String[] args) {
        List<Integer> list = List.of(-1, 1, 5, 7, -3);
        List<Integer> result =  list.stream().filter(x -> x >= 0).collect(Collectors.toList());
        System.out.println(result.toString());
    }
}
