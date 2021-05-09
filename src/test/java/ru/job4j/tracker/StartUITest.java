package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output output = new ConsoleOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction());
        actions.add(new ExitAction());
        new StartUI(output, in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new EditItem());
        actions.add(new ExitAction());
        new StartUI(output, in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[]{"0", Integer.toString(item.getId()), "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteItem());
        actions.add(new ExitAction());
        new StartUI(output, in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction());
        new StartUI(out, in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAllItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Added item"));
        String id = String.valueOf(item.getId());
        Input in = new StubInput(new String[]{"0", id, "1"});
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAllItem());
        actions.add(new ExitAction());
        new StartUI(out, in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. Show all items" + System.lineSeparator() + "1. Exit Program" + System.lineSeparator()
                + item + System.lineSeparator() + "Menu." + System.lineSeparator()
                + "0. Show all items" + System.lineSeparator() + "1. Exit Program" + System.lineSeparator()));
    }

    @Test
    public void whenFindByID() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Added item"));
        Input in = new StubInput(new String[]{"0", Integer.toString(item.getId()), "1"});
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new FindById());
        actions.add(new ExitAction());
        new StartUI(out, in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is("Added item"));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Added item"));
        String name = String.valueOf(item.getName());
        Input in = new StubInput(new String[]{"0", name, "1"});
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new FindByName());
        actions.add(new ExitAction());
        new StartUI(out, in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Find by Name%n"
                                + "1. Exit Program%n"
                                + item + System.lineSeparator()
                                + "Menu.%n"
                                + "0. Find by Name%n"
                                + "1. Exit Program%n")));
    }
}