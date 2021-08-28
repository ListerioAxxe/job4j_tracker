package ru.job4j.tracker;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output output = new ConsoleOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        MemTracker tracker = new MemTracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction());
        actions.add(new ExitAction());
        new StartUI(output, in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new ConsoleOutput();
        MemTracker tracker = new MemTracker();
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
        MemTracker tracker = new MemTracker();
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
        MemTracker tracker = new MemTracker();
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
        MemTracker tracker = new MemTracker();
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
        MemTracker tracker = new MemTracker();
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
        MemTracker tracker = new MemTracker();
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

    @Test
    public void executeEditAction() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        EditItem rep = new EditItem();
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);
        rep.execute(input, tracker, out);
        MatcherAssert.assertThat(out.toString(), is("Successful\r\n"));
        MatcherAssert.assertThat(tracker.findAll().get(0).getName(), is(replacedName));
    }

    @Test
    public void executeDeleteAction() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Item"));
        DeleteItem delete = new DeleteItem();
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        delete.execute(input, tracker, out);
        MatcherAssert.assertThat(out.toString(), is("Successful\r\n"));
        assertEquals(0, tracker.findAll().size());
    }

    @Test
    public void executeFindByIdAction() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        FindById find = new FindById();
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        find.execute(input, tracker, out);
        MatcherAssert.assertThat(out.toString(), is("Заявка с таким ID не найдена\r\n"));
        assertNull(tracker.findById(0));
    }

    @Test
    public void executeFindByNameAction() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        FindByName findByName = new FindByName();
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("Item");
        findByName.execute(input, tracker, out);
        MatcherAssert.assertThat(out.toString(), is("Заявка с таким именем не найдены\r\n"));
        assertEquals(tracker.findByName("Item"), Collections.emptyList());
    }
}