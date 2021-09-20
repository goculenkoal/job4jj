package ru.job4j.tracker;

public class DeleteItemAct implements UserAction {
    private final Output out;

    public DeleteItemAct(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
            out.println("=== Delete item ====;");
            int id = input.askInt("Enter id: ");
            if (tracker.delete(id)) {
                out.println("Success");
            } else {
                out.println("Error");
            }
            return true;
    }
}

