package ru.job4j.ex;

import junit.framework.TestCase;
import org.junit.Test;

public class FactTest1 extends TestCase {

    @Test(expected = IllegalArgumentException.class)
    public void testCalc() {
        new Fact().calc(5);
        }
    }