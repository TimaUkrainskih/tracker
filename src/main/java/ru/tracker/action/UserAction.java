package ru.tracker.action;

import ru.tracker.Store;
import ru.tracker.input.Input;

public interface UserAction {
    String name();

    boolean execute(Input input, Store tracker);
}