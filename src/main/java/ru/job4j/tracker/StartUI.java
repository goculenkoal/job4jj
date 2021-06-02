package ru.job4j.tracker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StartUI {

    public void init(BufferedReader reader, Tracker tracker) throws IOException {
        boolean run = true;
        while (run) {
            showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(reader.readLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ===");
                System.out.print("Enter name: ");
                String name = reader.readLine();
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Added Item: " + item);
            } else if (select == 1) {
                System.out.println("=== Show all items ====");
                Item[] items = tracker.findAll();
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("The store is empty");
                }
            } else if (select == 2) {
                System.out.println("=== Edit Item ====");
                System.out.print("Enter id: ");
                int id = Integer.parseInt(reader.readLine());
                System.out.print("Enter name: ");
                String name = reader.readLine();
                Item item = new Item(name);
                if (tracker.replace(id, item)) {
                    System.out.println("Success");
                } else {
                    System.out.println("Error");
                }

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

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Tracker tracker = new Tracker();
        new StartUI().init(reader, tracker);
    }
}

