package ru.job4j.tracker;

import java.io.IOException;

public class StubInput implements Input {
    private String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String askString(String input) throws IOException {
        return answers[position++];
    }

    @Override
    public int askInt(String input) throws IOException {
        return Integer.parseInt(askString(input));
    }
}
