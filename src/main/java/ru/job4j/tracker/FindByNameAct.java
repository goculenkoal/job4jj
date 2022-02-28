package ru.job4j.tracker;
import java.util.List;

public class FindByNameAct implements UserAction {
    private final Output out;

    public FindByNameAct(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find Item by name ====");
        String name = input.askString("Enter name: ");
        List<Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Wrong name: " + name + " == Item not found ==");
        }
        return true;
    }
}
