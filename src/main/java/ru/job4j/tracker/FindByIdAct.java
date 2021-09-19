package ru.job4j.tracker;

import java.io.IOException;

public class FindByIdAct implements UserAction {
    private final Output out;

    public FindByIdAct(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) throws IOException {
        out.println("=== Find Item by ID ====");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            out.println(item);
        } else {
            out.println("Wrong id: " + id + " == Item not found ==");
        }
        return true;
    }
}
