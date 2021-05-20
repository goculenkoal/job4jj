package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Objects;

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
     *
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
     *
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
     *
     * @param id - поиск по данному id
     * @return result - возвращаем найденную заявку, если заявки не существует - возвращаем - null;
     */
    public Item findById(int id) {
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items[index] : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
       int index = indexOf(id);
       if (id != -1) {
           item.setId(id);
           items[index] = item;
           return true;
       }
       return false;
    }
}