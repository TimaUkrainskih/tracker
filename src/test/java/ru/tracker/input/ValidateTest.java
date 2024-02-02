package ru.tracker.input;

import org.junit.jupiter.api.Test;
import ru.tracker.output.Output;
import ru.tracker.output.Stub;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateTest {

    @Test
    void whenInvalidInput() {
        Output output = new Stub();
        Input in = new Mock(
                new String[]{"one", "1"}
        );
        Validate input = new Validate(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenCorrectInput() {
        Output output = new Stub();
        Input in = new Mock(
                new String[]{"2"}
        );
        Validate input = new Validate(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(2);
    }

    @Test
    void whenMultipleCorrectInput() {
        Output output = new Stub();
        Input in = new Mock(
                new String[]{"2", "3", "4", "5"}
        );
        Validate input = new Validate(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(2);
        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(3);
        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(4);
        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(5);
    }

    @Test
    void whenNegativeNumberInput() {
        Output output = new Stub();
        Input in = new Mock(
                new String[]{"-2", "-3"}
        );
        Validate input = new Validate(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-2);
        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-3);
    }
}