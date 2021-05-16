package ru.job4j.lambda;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class LineFunctionTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = LineFunction.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenPowFunctionThenPowResults() {
        List<Double> result = LineFunction.diapason(5, 8, x ->  Math.pow(x, 2) + 5);
        List<Double> expected = Arrays.asList(30D, 41D, 54D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSqrtFunctionThenSqrtResults() {
        List<Double> result = LineFunction.diapason(9, 10, x ->  Math.sqrt(x) + 5.5);
        List<Double> expected = Arrays.asList(8.5);
        assertThat(result, is(expected));
    }

}