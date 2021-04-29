package ru.job4j.tracker;


import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class OutputTests {

    @Test
    public void testShowAll() {
    String sep = System.lineSeparator();
    Tracker tracker = new Tracker();
    Item debg = new Item("debug");
    tracker.add(debg);
    Output out = new StubOutput();
    Input in = new StubInput(new String[] {"0", "1"});
    UserAction[] actions = {
            new ShowAllItem(out),
            new ExitAction(),
    };

            new StartUI(out).init(in, tracker, actions);
    assertThat(out.toString(), is("Menu." + sep + "0. Show all items" + sep + "1. Exit Program" + sep
                                           + debg + sep
                                    + "Menu." + sep + "0. Show all items" + sep + "1. Exit Program" + sep));
    }

    @Test
    public void testFindByName() {
        String sep = System.lineSeparator();
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"0", "item", "1"});
        UserAction[] actions = {
                new FindByName(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + sep + "0. Find by Name" + sep
                + "1. Exit Program" + sep + "Заявка с таким именем не найдены" + sep + "Menu."
                + sep + "0. Find by Name" + sep + "1. Exit Program" + sep));
    }

    @Test
    public void testFindById() {
        String sep = System.lineSeparator();
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"0", "1", "1"});
        UserAction[] actions = {
                new FindById(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
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
        Tracker tracker = new Tracker();
        UserAction[] actions = new UserAction[]{
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        String sep = System.lineSeparator();
        assertThat(out.toString(), is(
                         "Menu." + sep
                        + "0. Exit Program" + sep
                        + "Wrong input, you can select: 0 .. 0" + sep
                        + "Menu." + sep
                        + "0. Exit Program" + sep
                )
        );
    }
}