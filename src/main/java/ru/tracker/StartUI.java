package ru.tracker;

import ru.tracker.action.*;
import ru.tracker.input.ConsoleInput;
import ru.tracker.input.Input;
import ru.tracker.input.Validate;
import ru.tracker.output.ConsoleOutput;
import ru.tracker.output.Output;

import java.util.List;

public class StartUI {
    private final Output output;

    public StartUI(Output output) {
        this.output = output;
    }

    public void init(Input input, Store tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Выбрать: ");
            if (select >= 0 && actions.size() > select) {
                UserAction action = actions.get(select);
                run = action.execute(input, tracker);
            } else {
                output.println("Неверный ввод, вы можете выбрать: 0 ... " + actions.size());
            }
        }
    }

    private void showMenu(List<UserAction> actions) {
        output.println("Меню:");
        for (int index = 0; index < actions.size(); index++) {
            output.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new Validate(output, new ConsoleInput());
        Store tracker = new MemTracker();
        List<UserAction> actions = List.of(new Create(output),
                new FindAll(output),
                new Replace(output),
                new Delete(output),
                new FindById(output),
                new FindByName(output),
                new Exit(output));
        new StartUI(output).init(input, tracker, actions);
    }
}