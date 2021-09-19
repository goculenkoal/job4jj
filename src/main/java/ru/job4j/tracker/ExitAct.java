package ru.job4j.tracker;

public class ExitAct implements UserAction {
    private final Output out;

    public ExitAct(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Exit";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        return false;
    }
}
