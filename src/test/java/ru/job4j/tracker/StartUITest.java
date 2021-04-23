package ru.job4j.tracker;

import junit.framework.TestCase;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StartUITest extends TestCase {

    public void testCreateItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));

    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()),
                "replaced item"
        };
        StartUI.editItem(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        Assert.assertThat(replaced.getName(), is("replaced item"));
    }

    public void testDelete() {
        Tracker tracker = new Tracker();
        Item item = new Item("first item");
        tracker.add(item);
        String[] answers = {String.valueOf(item.getId())};
        StartUI.deleteItem(new StubInput(answers), tracker);
        Item deleted = tracker.findById(item.getId());
        Assert.assertNull(null, deleted);

    }
}