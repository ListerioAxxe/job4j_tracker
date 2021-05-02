package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output output = new ConsoleOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ExitAction()
        };
        new StartUI(output, in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new EditItem(),
                new ExitAction()
        };
        new StartUI(output, in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteItem(),
                new ExitAction()
        };
        new StartUI(output, in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out, in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator()
        ));
    }
    @Test
    public void whenFindAllItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Added item"));
        String id = String.valueOf(item.getId());
        Input in = new StubInput(new String[]{"0", id, "1"});
        UserAction[] actions = {new ShowAllItem(), new ExitAction()};
        new StartUI(out, in, tracker, actions);
        assertThat(out.toString(), is("=== Show all Items ===" + System.lineSeparator() + tracker.findById(item.getId()) + System.lineSeparator()));
    }

    @Test
    public void whenFindByID() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Added item"));
        String id = String.valueOf(item.getId());
        Input in = new StubInput(new String[]{"0", id, "1"});
        UserAction[] actions = {new FindById(), new ExitAction()};
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
        UserAction[] actions = {new FindByName(), new ExitAction()};
        new StartUI(out, in, tracker, actions);
        assertThat(tracker.findByName(item.getName()), is("Added item"));
    }
}