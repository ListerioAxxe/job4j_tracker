package ru.job4j.tracker;


import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class OutputTests {

    @Test
    public void testShowAll() {
    String sep = System.lineSeparator();
    Tracker tracker = new Tracker();
    Output out = new StubOutput();
    Input in = new StubInput(new String[] {"0", "1"} );
    UserAction[] actions = {
            new ShowAllItem(out),
            new ExitAction(),
    };

            new StartUI(out).init(in, tracker, actions);
    assertThat(out.toString(), is("Menu." + sep + "0. Show all items" + sep + "1. Exit Program" + sep
                                    + "Menu." + sep + "0. Show all items" + sep + "1. Exit Program" + sep));
}
    @Test
    public void testFindByName() {
        String sep = System.lineSeparator();
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"1", "2"});
        UserAction[] actions = {
                new FindByName(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + sep + "0. Find by Name" + sep + "1. Exit Program" + sep));
    }
    @Test
    public void testFindById() {
        String sep = System.lineSeparator();
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"1", "2"} );
        UserAction[] actions = {
                new FindById(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + sep + "0. Find by ID" + sep + "1. Exit Program" + sep));
    }
}