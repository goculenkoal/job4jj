package ru.job4j.tracker;
import java.util.ArrayList;

public class Tracker {
    private final ArrayList<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    /**
     * Метод реализации добавления заявки в хранилище
     *
     * @param item - добавление объекта типа Item.
     */
    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    /**
     * Метод получения всех заявок.
     *
     * @return возврат нового массива без null элементов.
     */

    public ArrayList<Item> findAll() {
        ArrayList<Item> result = new ArrayList<>();
        result.addAll(items);
        return result;
    }

    /**
     * Метод получения списка заявок, у которых совпадает имя.
     *
     * @param keyName - имя заявки
     * @return - возврат массива result без null элементов.
     */

    public ArrayList<Item> findByName(String keyName) {
        ArrayList<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().contains(keyName)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Метод поиска по ID
     *
     * @param id - поиск по данному id
     * @return result - возвращаем найденную заявку, если заявки не существует - возвращаем - null;
     */
    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

  private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean result = false;
         if (index != -1) {
           item.setId(id);
           items.set(index, item);
           result = true;
       }
       return result;
    }

    public boolean delete(int id) {
        boolean result = false;
        int index = indexOf(id);
        if (index != -1) {
            items.remove(index);
            result = true;
        }
        return result;
    }
}