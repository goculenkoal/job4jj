package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker trackerTest1 = new Tracker();
        Item item1 = new Item();
        item1.setName("test123");
        trackerTest1.add(item1);
        System.out.println(trackerTest1.findById(item1.getId()).toString());
    }
}
