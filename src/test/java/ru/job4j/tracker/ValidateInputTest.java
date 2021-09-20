package ru.job4j.tracker;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {
    @Test
    public void whenInvalidInput() throws IOException {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() throws IOException {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenMultipleValidInput() throws IOException {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "2", "4", "5" }
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected =  0;
        for (int i = 0; i < 4; i++) {
        selected = input.askInt("Enter menu:");
        }
        assertThat(selected, is(5));
    }

    @Test
    public void whenNegativeValidInput() throws IOException {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"-1", "-2", "4", "-5" }
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected =  0;
        for (int i = 0; i < 4; i++) {
            selected = input.askInt("Enter menu:");
        }
        assertThat(selected, is(-5));
    }
}