package ru.tracker;

import ru.tracker.action.*;
import ru.tracker.input.Input;
import ru.tracker.input.ValidateInput;
import ru.tracker.output.Console;
import ru.tracker.output.Output;

public class StartUI {
    private final Output output;

    public StartUI(Output output) {
        this.output = output;
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Выбрать: ");
            if (select >= 0 && 6 >= select) {
                UserAction action = actions[select];
                run = action.execute(input, tracker);
            } else {
                output.println("Вы выбрали несуществующий пункт меню");
            }



        }
    }

    private void showMenu(UserAction[] actions) {
        output.println("Меню:");
        for (int index = 0; index < actions.length; index++) {
            output.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Output output = new Console();
        Input input = new ValidateInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Create(output),
                new FindAll(output),
                new Replace(output),
                new Delete(output),
                new FindById(output),
                new FindByName(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
    }
}