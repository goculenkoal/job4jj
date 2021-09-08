package ru.job4j.tracker;

import java.io.IOException;

public class CreateItemAct implements UserAction {
    @Override
    public String name() {
        return "Add new Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) throws IOException {
        System.out.println("=== Create a new Item ===");
        String name = input.askString("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Added Item: " + item);
        return true;
    }
}
