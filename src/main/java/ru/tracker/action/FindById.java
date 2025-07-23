package ru.tracker.action;

import ru.tracker.Item;
import ru.tracker.MemTracker;
import ru.tracker.Store;
import ru.tracker.input.Input;
import ru.tracker.output.Output;

public class FindById implements UserAction {
    private Output output;

    public FindById(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Показать заявку по id";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        output.println("=== Вывод заявки по id ===");
        int id = input.askInt("Введите id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            output.println(item);
        } else {
            output.println("Заявка с введенным id: " + id + " не найдена.");
        }
        return true;
    }
}
