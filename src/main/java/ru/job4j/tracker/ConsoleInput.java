package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {

   private Scanner scanner = new Scanner(System.in);

    @Override
    public String askString(String input) {
        System.out.println(input);
        return scanner.nextLine();
    }

    @Override
    public int askInt(String input)  {
        return Integer.parseInt(askString(input));
    }
}
