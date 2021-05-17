package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraytoList {
    public static List<Integer> convert(Integer[][] array) {
       return Arrays.stream(array)
               .flatMap(Arrays::stream)
               .collect(Collectors.toList());
    }
}
