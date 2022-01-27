package ru.job4j.tracker;

import java.util.ArrayList;

public class ShowAllItemsAct implements UserAction {
    private final Output out;

    public ShowAllItemsAct(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker)  {
        out.println("=== Show all items ====");
        ArrayList<Item> items = tracker.findAll();
        if (items.size() > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("The store is empty");
        }
        return true;
    }
}
