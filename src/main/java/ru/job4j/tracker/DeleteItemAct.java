package ru.job4j.tracker;

import java.io.IOException;

public class DeleteItemAct implements UserAction {
    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) throws IOException {
            System.out.println("=== Delete item ====;");
            int id = input.askInt("Enter id: ");
            if (tracker.delete(id)) {
                System.out.println("Success");
            } else {
                System.out.println("Error");
            }
            return true;
    }
}

