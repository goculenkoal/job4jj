package queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        String nameResult = "";
        for (int i = 0; i < count; i++) {
            nameResult = queue.poll().name();
        }
        return nameResult;
    }

    public String getFirstUpsetCustomer() {
        String nameResult = "";
        for (int i = 0; i < count + 1; i++) {
            nameResult = queue.poll().name();
        }
        return nameResult;
    }
}