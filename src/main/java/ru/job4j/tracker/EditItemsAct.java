package ru.job4j.tracker;

import java.io.IOException;

public class EditItemsAct implements UserAction {
    @Override
    public String name() {
        return "Edit name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) throws IOException {
            System.out.println("=== Edit Item ====");
            int id = input.askInt("Enter id: ");
            String name = input.askString("Enter name: ");
            Item item = new Item(name);
            if (tracker.replace(id, item)) {
                System.out.println("Success");
            } else {
                System.out.println("Error");
            }
            return true;
    }
}

