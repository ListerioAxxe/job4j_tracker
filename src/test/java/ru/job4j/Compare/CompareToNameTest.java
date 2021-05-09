package ru.job4j.Compare;


import org.junit.Test;
import ru.job4j.tracker.Item;

import static java.util.Collections.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CompareToNameTest {
     @Test
    public void compareToNameTest() {
    List<Item> lists = new ArrayList<>();
    Item first = new Item("andreu");
    Item sec = new  Item("igor");
    Item third = new Item("zaur");
    lists.add(first);
    lists.add(sec);
    lists.add(third);

         List<Item> lists1 = new ArrayList<>();
         lists1.add(sec);
         lists1.add(first);
         lists1.add(third);
         lists1.sort(new CompareToName());

    assertThat(lists, is(lists1));
    }

    @Test
    public void compareToNameReverseTest() {
        List<Item> lists = new ArrayList<>();
        Item first = new Item("andreu");
        Item sec = new  Item("igor");
        Item third = new Item("zaur");
        lists.add(third);
        lists.add(sec);
        lists.add(first);

        List<Item> lists1 = new ArrayList<>();
        lists1.add(sec);
        lists1.add(first);
        lists1.add(third);
        lists1.sort(new CompareNameRevers());

        assertThat(lists, is(lists1));
    }

    @Test
    public void compareToIdReverse() {
        List<Item> lists = new ArrayList<>();
        Item first = new Item(1);
        Item sec = new  Item(2);
        Item third = new Item(3);
        lists.add(third);
        lists.add(sec);
        lists.add(first);

        List<Item> lists1 = new ArrayList<>();
        lists1.add(sec);
        lists1.add(first);
        lists1.add(third);
        lists1.sort(new CompareIdRevers());

        assertThat(lists, is(lists1));
    }

    @Test
    public void compareToId() {
        List<Item> lists = new ArrayList<>();
        Item first = new Item(1);
        Item sec = new  Item(2);
        Item third = new Item(3);
        lists.add(first);
        lists.add(sec);
        lists.add(third);

        List<Item> lists1 = new ArrayList<>();
        lists1.add(sec);
        lists1.add(first);
        lists1.add(third);
        Collections.sort(lists1);

        assertThat(lists, is(lists1));
    }
}