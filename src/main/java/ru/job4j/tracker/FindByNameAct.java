package ru.job4j.tracker;

import java.io.IOException;

public class FindByNameAct implements UserAction {
    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) throws IOException {
        System.out.println("=== Find Item by name ====");
        String name = input.askString("Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Wrong name: " + name + " == Item not found ==");
        }
        return true;
    }
}
