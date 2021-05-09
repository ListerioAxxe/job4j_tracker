package ru.job4j.collection;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class JobCompareByNameTest {
      @Test
    public void testCompareByName() {
        List<Job> list= new ArrayList<>();
        list.add(new Job("sveta", 5));
        list.add(new Job("igor", 6));
        list.add(new Job("andry", 7));
        Collections.sort(list, new JobCompareByName());

        List<Job> exp = new ArrayList<>();
          exp.add(new Job("andry", 7));
          exp.add(new Job("igor", 6));
          exp.add(new Job("sveta", 5));

        assertThat(list, is(exp));
    }

    @Test
    public void testCompareByPriority() {
        List<Job> list = new ArrayList<>();
        list.add(new Job("sveta", 7));
        list.add(new Job("igor", 5));
        list.add(new Job("andry", 3));
        Collections.sort(list, new JobCompareByPriority());

        List<Job> exp = new ArrayList<>();
        exp.add(new Job("andry", 3));
        exp.add(new Job("igor", 5));
        exp.add(new Job("sveta", 7));

        assertThat(list, is(exp));
    }

    @Test
    public void testCompareDeskByName() {
        List<Job> list = new ArrayList<>();
        list.add(new Job("andry", 3));
        list.add(new Job("igor", 5));
        list.add(new Job("sveta", 7));
        Collections.sort(list, new JobDescByName());

        List<Job> exp = new ArrayList<>();
        exp.add(new Job("sveta", 7));
        exp.add(new Job("igor", 5));
        exp.add(new Job("andry", 3));

        assertThat(list, is(exp));
    }

    @Test
    public void testCompareDeskByPriority() {
        List<Job> list = new ArrayList<>();
        list.add(new Job("andry", 3));
        list.add(new Job("igor", 5));
        list.add(new Job("sveta", 7));
        Collections.sort(list, new JobDescByPriority());

        List<Job> exp = new ArrayList<>();
        exp.add(new Job("sveta", 7));
        exp.add(new Job("igor", 5));
        exp.add(new Job("andry", 3));

        assertThat(list, is(exp));
    }

    @Test
    public void testCompareDeskByNameThenPr() {
        List<Job> list = new ArrayList<>();
        list.add(new Job("andry", 3));
        list.add(new Job("igor", 5));
        list.add(new Job("sveta", 7));
        list.add(new Job("sveta", 9));
        list.add(new Job("andry", 11));
        Collections.sort(list, new JobCompareByName().thenComparing(new JobCompareByPriority()));

        List<Job> exp = new ArrayList<>();
        exp.add(new Job("andry", 3));
        exp.add(new Job("andry", 11));
        exp.add(new Job("igor", 5));
        exp.add(new Job("sveta", 7));
        exp.add(new Job("sveta", 9));
        assertThat(list, is(exp));
    }
}