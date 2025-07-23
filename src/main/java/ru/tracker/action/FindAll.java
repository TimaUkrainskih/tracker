package ru.tracker.action;

import ru.tracker.Item;
import ru.tracker.MemTracker;
import ru.tracker.Store;
import ru.tracker.input.Input;
import ru.tracker.output.Output;

import java.util.List;

public class FindAll implements UserAction {
    private Output output;

    public FindAll(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Показать все заявки";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        output.println("=== Вывод всех заявок ===");
        List<Item> items = tracker.findAll();
        if (!items.isEmpty()) {
            for (Item item : items) {
                output.println(item);
            }
        } else {
            output.println("Хранилище еще не содержит заявок");
        }
        return true;
    }
}
