package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    /**
     * Метод реализации добавления заявки в хранилище
     *
     * @param item - добавление объекта типа Item.
     */
    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    /**
     * Метод получения всех заявок.
     * @return возврат массива result без null элементов.
     */
    public Item[] findAll() {
        Item[] result = new Item[size]; // создание массива result размером size
        int count = 0; //счетчик нового массива
        for (int index = 0; index < size; index++) { //луп для прохода по массиву
             Item item = items[index]; //запись i - го объекта  из массива items;
            if (item != null) {
                result[count] = item;
                count++;
            }
        }
        return Arrays.copyOf(result, count);
    }

    /**
     * Метод получения списка заявок, у которых совпадает имя.
     * @param name - имя заявки
     * @return - возврат массива result без null элементов.
     */
    public Item[] findByName(String name) {
        Item[] result = new Item[size];
        int count = 0;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getName().equals(name)) {
                result[count] = item;
                count++;
            }
        }
        return Arrays.copyOf(result, count);
    }

    /**
     * Метод поиска по ID
     * @param id - поиск по данному id
     * @return result - возвращаем найденную заявку, если заявки не существует - возвращаем - null;
     */
    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}