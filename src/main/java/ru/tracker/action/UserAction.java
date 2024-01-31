package ru.tracker.action;

import ru.tracker.Tracker;
import ru.tracker.input.Input;

public interface UserAction {
    String name();

    boolean execute(Input input, Tracker tracker);
}