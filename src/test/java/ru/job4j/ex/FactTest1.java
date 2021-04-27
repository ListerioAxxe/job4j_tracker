package ru.job4j.ex;

import org.junit.Test;

public class FactTest1 {

    @Test(expected = IllegalArgumentException.class)
    public void testCalc() {
        new Fact().calc(-1);
        }
    }