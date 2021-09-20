package ru.job4j.tracker;

public class StubInput implements Input {
    private String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String askString(String input) {
        return answers[position++];
    }

    @Override
    public int askInt(String input)  {
        return Integer.parseInt(askString(input));
    }
}
