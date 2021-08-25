package ru.job4j.tracker;

import java.io.IOException;

public interface Input {
    String askString(String input) throws IOException;

    int askInt(String input) throws IOException;
}
