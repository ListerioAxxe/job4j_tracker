package ru.job4j.collection;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static java.lang.CharSequence.compare;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class DepartmentsTest {
    @Test
    public void whenMissed() {
        List<String> input = Arrays.asList("k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenNonChange() {
        List<String> input = Arrays.asList("k1", "k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void testSortAsc() {
        int rsl = compare(
                "dep1",
                "dep1/subdep"
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void testSortDesc() {
        int rsl = new DepDescComp().compare(
                "dep1",
                "dep1/subdep"
        );
        assertThat(rsl, lessThan(0));
    }
}