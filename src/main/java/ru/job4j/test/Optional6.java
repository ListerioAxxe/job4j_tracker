package ru.job4j.test;

import java.util.Optional;

public class Optional6 {
    public static Integer orElse(Optional<Integer> optional) {
       return optional.orElse(-1);
    }
}


        /*   Integer value = -1;
        if (optional.isPresent()) {
            value = optional.get();
        }
        return value;*/
