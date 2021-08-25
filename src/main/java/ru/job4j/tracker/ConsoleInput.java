package ru.job4j.tracker;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput implements Input {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public String askString(String input) throws IOException {
        System.out.println(input);
        return reader.readLine();
    }

    @Override
    public int askInt(String input) throws IOException  {
        return Integer.parseInt(askString(input));
    }
}
