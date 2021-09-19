package ru.job4j.tracker;

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
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("The store is empty");
        }
        return true;
    }
}
