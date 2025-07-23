package ru.tracker.action;

import ru.tracker.MemTracker;
import ru.tracker.Store;
import ru.tracker.input.Input;
import ru.tracker.output.Output;

public class Delete implements UserAction {
    private final Output output;

    public Delete(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Удалить заявку";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        output.println("=== Удаление заявки ===");
        int id = input.askInt("Введите id: ");
        tracker.delete(id);
        if (tracker.findById(id) == null) {
            output.println("Заявка удалена успешно.");
        } else {
            output.println("Ошибка удаления заявки.");
        }
        return true;
    }
}
