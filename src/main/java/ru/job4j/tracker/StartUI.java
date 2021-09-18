package ru.job4j.tracker;


import java.io.IOException;

public class StartUI {

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
        System.out.println("Menu: ");
        for (int i = 0; i < actions.length; i++) {
            System.out.println(i + ". " + actions[i].name());
        }
    }

    public static void main(String[] args) throws IOException {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateItemAct(), new ShowAllItemsAct(), new EditItemsAct(),
                new DeleteItemAct(), new FindByIdAct(), new FindByNameAct(), new ExitAct()
        };
        new StartUI().init(input, tracker, actions);
    }
}

