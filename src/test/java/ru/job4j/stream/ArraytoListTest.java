package ru.job4j.stream;


import org.junit.Test;

import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ArraytoListTest {
    @Test
    public void arrayConvert() {
        Integer[][] array = new Integer[][]{{1, 2}, {3, 4}};
        List<Integer> list = ArraytoList.convert(array);
        List<Integer> exp = List.of(1, 2, 3, 4);
        assertThat(list, is(exp));
    }
}