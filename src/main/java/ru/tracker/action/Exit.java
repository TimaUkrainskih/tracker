package ru.tracker.action;

import ru.tracker.Tracker;
import ru.tracker.input.Input;
import ru.tracker.output.Output;

public class Exit implements UserAction {
    private Output output;

    public Exit(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Завершить программу";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Завершение программы ===");
        return false;
    }
}