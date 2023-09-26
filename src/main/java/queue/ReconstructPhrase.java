package queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder rsl = new StringBuilder();
        int dequeSize = evenElements.size();
        for (int i = 0; i < dequeSize; i++) {
            if (i % 2 == 0) {
             Character c = evenElements.poll();
                assert c != null;
                rsl.append(c);
            } else {
                evenElements.remove();
            }

        }
        return rsl.toString();
    }

    private String getDescendingElements() {
        StringBuilder rsl = new StringBuilder();
        int dequeSize = descendingElements.size();
        for (int i = 0; i < dequeSize; i++) {
            Character c = descendingElements.pollLast();
            assert c != null;
            rsl.append(c);

        }
        return rsl.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}