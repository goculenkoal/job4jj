package ru.job4j.tracker;

import static org.hamcrest.core.IsNull.nullValue;
import org.junit.Test;
import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
                actions.add(new EditItemsAct(out));
                actions.add(new ExitAct(out));

        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteItemAct(out));
        actions.add(new ExitAct(out));

        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenFindAllItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1"));
        Input in =  new StubInput(
                new String[]{"0", "1"}
        );

        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAllItemsAct(out));
        actions.add(new ExitAct(out));

        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu: " + System.lineSeparator()
                + "0. Show all items" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "=== Show all items ====" + System.lineSeparator()
                + item + System.lineSeparator()
                + "Menu: " + System.lineSeparator()
                + "0. Show all items" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()

        ));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[]{"0", "test1", "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new FindByNameAct(out));
        actions.add(new ExitAct(out));

        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu: " + System.lineSeparator()
                        + "0. Find items by name" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "=== Find Item by name ====" + System.lineSeparator()
                        + item + System.lineSeparator()
                        + "Menu: " + System.lineSeparator()
                        + "0. Find items by name" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()

        ));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );

        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new FindByIdAct(out));
        actions.add(new ExitAct(out));

        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu: " + System.lineSeparator()
                        + "0. Find item by id" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "=== Find Item by ID ====" + System.lineSeparator()
                        + item + System.lineSeparator()
                        + "Menu: " + System.lineSeparator()
                        + "0. Find item by id" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()

        ));
    }

    @Test
    public void whenExit()  {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );

        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
                actions.add(new ExitAct(out));

        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu: " + System.lineSeparator()
                        + "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"100", "0"}
        );
        Tracker tracker = new Tracker();

        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAct(out));

        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                        "Menu: " + ln
                                + "0. Exit" + ln
                                + "Wrong input, you can select: 0 .. 0" + ln
                                + "Menu: " + ln
                                + "0. Exit" + ln
                )
        );
    }
}

