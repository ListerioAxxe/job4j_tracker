package ru.job4j.tracker;


import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OutputTests {

    @Test
    public void testShowAll() {
    String sep = System.lineSeparator();
    MemTracker tracker = new MemTracker();
    Item debg = new Item("debug");
    tracker.add(debg);
    Output out = new StubOutput();
    Input in = new StubInput(new String[] {"0", "1"});
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAllItem());
        actions.add(new ExitAction());

            new StartUI(out, in, tracker, actions);
    assertThat(out.toString(), is("Menu." + sep + "0. Show all items" + sep + "1. Exit Program" + sep
                                           + debg + sep
                                    + "Menu." + sep + "0. Show all items" + sep + "1. Exit Program" + sep));
    }

    @Test
    public void testFindByName() {
        String sep = System.lineSeparator();
        MemTracker tracker = new MemTracker();
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"0", "item", "1"});
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new FindByName());
        actions.add(new ExitAction());
        new StartUI(out, in, tracker, actions);
        assertThat(out.toString(), is("Menu." + sep + "0. Find by Name" + sep
                + "1. Exit Program" + sep + "Заявка с таким именем не найдены" + sep + "Menu."
                + sep + "0. Find by Name" + sep + "1. Exit Program" + sep));
    }

    @Test
    public void testFindById() {
        String sep = System.lineSeparator();
        MemTracker tracker = new MemTracker();
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"0", "2", "1"});
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new FindById());
        actions.add(new ExitAction());
        new StartUI(out, in, tracker, actions);
        assertThat(out.toString(), is("Menu." + sep + "0. Find by ID" + sep
                + "1. Exit Program" + sep + "Заявка с таким ID не найдена" + sep + "Menu."
                + sep + "0. Find by ID" + sep + "1. Exit Program" + sep));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"8", "0"}
        );
        MemTracker tracker = new MemTracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction());
        new StartUI(out, in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Exit Program" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu." + ln
                        + "0. Exit Program" + ln
                )
        );
    }
}