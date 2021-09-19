package ru.job4j.tracker;


import java.io.IOException;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) throws IOException {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        out.println("Menu: ");
        for (int i = 0; i < actions.length; i++) {
            out.println(i + ". " + actions[i].name());
        }
    }

    public static void main(String[] args) throws IOException {
        Output output = new ConsoleOutput();
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateItemAct(output), new ShowAllItemsAct(output), new EditItemsAct(output),
                new DeleteItemAct(output), new FindByIdAct(output), new FindByNameAct(output), new ExitAct(output)
        };
        new StartUI(output).init(input, tracker, actions);
    }
}

