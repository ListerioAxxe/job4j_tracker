package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenInvalidInput1() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"2", "3", "4"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(2));
        selected = input.askInt("Enter menu:");
        assertThat(selected, is(3));
        selected = input.askInt("Enter menu:");
        assertThat(selected, is(4));

    }

    @Test
    public void whenInvalidInputError() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"-1", "-2", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }


}