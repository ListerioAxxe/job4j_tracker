package ru.job4j.test;

import java.util.List;
import java.util.Optional;

public class Optional5 {
    public static Optional<String> findValue(List<String> strings, String value) {
        if (value != null) {
      for (var el : strings) {
          if (el.equals(value)) {
              return Optional.ofNullable(el);
          }
      }
      }
      return Optional.empty();
    }
}
