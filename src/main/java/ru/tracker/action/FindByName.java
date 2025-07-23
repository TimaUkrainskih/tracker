package ru.tracker.action;

import ru.tracker.Item;
import ru.tracker.MemTracker;
import ru.tracker.Store;
import ru.tracker.input.Input;
import ru.tracker.output.Output;

import java.util.List;

public class FindByName implements UserAction {
    private Output output;

    public FindByName(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Показать заявки по имени";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        output.println("=== Вывод заявок по имени ===");
        String name = input.askStr("Введите имя: ");
        List<Item> items = tracker.findByName(name);
        if (!items.isEmpty()) {
            for (Item item : items) {
                output.println(item);
            }
        } else {
            output.println("Заявки с именем: " + name + " не найдены.");
        }
        return true;
    }
}
