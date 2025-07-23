package ru.tracker;

import org.junit.jupiter.api.Test;
import ru.tracker.action.*;
import ru.tracker.input.Input;
import ru.tracker.input.Mock;
import ru.tracker.output.Output;
import ru.tracker.output.Stub;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {
    @Test
    void whenCreateItem() {
        Output output = new Stub();
        Input input = new Mock(
                new String[]{"0", "Item name", "1"}
        );
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = List.of(
                new Create(output),
                new Exit(output));
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("Item name");
    }

    @Test
    void whenReplaceItem() {
        Output output = new Stub();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input input = new Mock(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        List<UserAction> actions = List.of(
                new Replace(output),
                new Exit(output));
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    void whenDeleteItem() {
        Output output = new Stub();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input input = new Mock(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = List.of(
                new Delete(output),
                new Exit(output));
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    void whenReplaceItemTestOutputIsSuccessfully() {
        Output output = new Stub();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input input = new Mock(
                new String[]{"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        List<UserAction> actions = List.of(
                new Replace(output),
                new Exit(output));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Изменить заявку" + ln
                        + "1. Завершить программу" + ln
                        + "=== Редактирование заявки ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Меню:" + ln
                        + "0. Изменить заявку" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindAllItemTestOutputIsSuccessfully() {
        Output output = new Stub();
        MemTracker tracker = new MemTracker();
        Input input = new Mock(
                new String[]{"0", "1"}
        );
        List<UserAction> actions = List.of(
                new FindAll(output),
                new Exit(output));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать все заявки" + ln
                        + "1. Завершить программу" + ln
                        + "=== Вывод всех заявок ===" + ln
                        + "Хранилище еще не содержит заявок" + ln
                        + "Меню:" + ln
                        + "0. Показать все заявки" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindByNameItemTestOutputIsSuccessfully() {
        Output output = new Stub();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        Input input = new Mock(
                new String[]{"0", one.getName(), "1"}
        );
        List<UserAction> actions = List.of(
                new FindByName(output),
                new Exit(output));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать заявки по имени" + ln
                        + "1. Завершить программу" + ln
                        + "=== Вывод заявок по имени ===" + ln
                        + one + ln
                        + "Меню:" + ln
                        + "0. Показать заявки по имени" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindByIdItemTestOutputIsSuccessfully() {
        Output output = new Stub();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        Input input = new Mock(
                new String[]{"0", String.valueOf(one.getId()), "1"}
        );
        List<UserAction> actions = List.of(
                new FindById(output),
                new Exit(output));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать заявку по id" + ln
                        + "1. Завершить программу" + ln
                        + "=== Вывод заявки по id ===" + ln
                        + one + ln
                        + "Меню:" + ln
                        + "0. Показать заявку по id" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenInvalidExit() {
        Output output = new Stub();
        Input input = new Mock(
                new String[]{"1", "0"}
        );
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = List.of(
                new Exit(output));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Завершить программу" + ln
                        + "Неверный ввод, вы можете выбрать: 0 ... 1" + ln
                        + "Меню:" + ln
                        + "0. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }
}