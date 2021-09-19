package ru.job4j.tracker;

import java.io.IOException;

public class EditItemsAct implements UserAction {
    private final Output out;

    public EditItemsAct(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) throws IOException {
            out.println("=== Edit Item ====");
            int id = input.askInt("Enter id: ");
            String name = input.askString("Enter name: ");
            Item item = new Item(name);
            if (tracker.replace(id, item)) {
                out.println("Success");
            } else {
                out.println("Error");
            }
            return true;
    }
}

