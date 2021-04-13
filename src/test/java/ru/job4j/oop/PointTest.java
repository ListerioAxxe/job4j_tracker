package ru.job4j.oop;

import junit.framework.TestCase;
import org.junit.Assert;

import static org.hamcrest.MatcherAssert.assertThat;

public class PointTest extends TestCase {

    public void testDistance3d() {
        Point first = new Point(0,0, 0);
        Point second = new Point(2,0, 0);
        double rsl = first.distance3d(second);
        double exp = 2;
        Assert.assertEquals(rsl, exp, 0.01);
        }

    }