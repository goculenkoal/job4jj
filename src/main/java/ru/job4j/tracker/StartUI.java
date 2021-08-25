package ru.job4j.tracker;


import java.io.IOException;
import java.io.InputStreamReader;

public class StartUI {
    public static void createItem(Input input, Tracker tracker) throws IOException {
        System.out.println("=== Create a new Item ===");
        String name = input.askString("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Added Item: " + item);
    }

    public static void showAllItems(Input input, Tracker tracker) {
        System.out.println("=== Show all items ====");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("The store is empty");
        }
    }

    public static void editItem(Input input, Tracker tracker) throws IOException {
        System.out.println("=== Edit Item ====");
        int id = input.askInt("Enter id: ");
        String name = input.askString("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Success");
        } else {
            System.out.println("Error");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) throws IOException {
        System.out.println("=== Delete item ====;");
        int id = input.askInt("Enter id: ");
        if (tracker.delete(id)) {
            System.out.println("Success");
        } else {
            System.out.println("Error");
        }
    }

    public static void findById(Input input, Tracker tracker) throws IOException {
        System.out.println("=== Find Item by ID ====");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Wrong id: " + id + " == Item not found ==");
        }
    }

    public static void findByName(Input input, Tracker tracker) throws IOException {
        System.out.println("=== Find Item by name ====");
        String name = input.askString("Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Wrong name: " + name + " == Item not found ==");
        }
    }

    public void init(Input input, Tracker tracker) throws IOException {
        boolean run = true;
        while (run) {
            showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
               StartUI.showAllItems(input, tracker);
            } else if (select == 2) {
                StartUI.editItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findById(input, tracker);
            } else if (select == 5) {
               StartUI.findByName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        String[] menu = {
                "Add a new Item", "Show all items", "Edit item",
                "Delete item", "Find item by id", "Find items by name",
                "Exit Program"
        };
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}

