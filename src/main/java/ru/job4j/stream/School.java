package ru.job4j.stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@SuppressWarnings("checkstyle:EmptyLineSeparator")
public class School {

    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }

    public static Map<String, Student> convert(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(Student::getSurname, student -> student, (x, y) -> x.equals(y) ? x : y));
    }
}
