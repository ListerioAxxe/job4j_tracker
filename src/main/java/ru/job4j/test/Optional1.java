package ru.job4j.test;

import java.util.List;
import java.util.Optional;

public class Optional1 {
    public static Optional<String> findValue(List<String> strings, String value) {
        for (var el : strings) {
            if (el.equals(value)) {
                return Optional.of(el);
            }
        }
        return Optional.empty();
    }
}
