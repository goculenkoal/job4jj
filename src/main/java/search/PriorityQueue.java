package search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определяется по полю приоритет.
     * Для вставки использовать add(int index, E value)
     * @param newTask задача
     */
    public void put(Task newTask) {
        int index = 0;
        for (Task element : tasks) {
            if (element.getPriority() > newTask.getPriority()) {
                break;
            }

            index++;
        }
        this.tasks.add(index, newTask);
    }

    public Task take() {
        return tasks.poll();
    }
}
