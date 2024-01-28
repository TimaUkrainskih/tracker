package ru.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            System.out.print("Выбрать: ");
            int select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 0:
                    System.out.println("=== Создание новой заявки ===");
                    System.out.print("Введите имя: ");
                    String name = scanner.nextLine();
                    Item item = new Item(name);
                    tracker.add(item);
                    System.out.println("Добавленная заявка: " + item);
                    break;
                case 1:
                    System.out.println("=== Вывод всех заявок ===");
                    Item[] items = tracker.findAll();
                    if (items.length > 0) {
                        for (Item it : items) {
                            System.out.println(it);
                        }
                    } else {
                        System.out.println("Хранилище еще не содержит заявок");
                    }
                    break;
                case 2:
                    System.out.println("=== Редактирование заявки ===");
                    System.out.print("Введите id: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Введите имя: ");
                    String nameEdit = scanner.nextLine();
                    Item itemEdit = new Item(nameEdit);
                    if (tracker.replace(id, itemEdit)) {
                        System.out.println("Заявка изменена успешно.");
                    } else {
                        System.out.println("Ошибка замены заявки.");
                    }
                    break;
                case 3:
                    System.out.println("=== Удаление заявки ===");
                    System.out.print("Введите id: ");
                    int idDelete = Integer.parseInt(scanner.nextLine());
                    Item itemDelete = tracker.findById(idDelete);
                    tracker.delete(idDelete);
                    if (itemDelete != null) {
                        System.out.println("Заявка удалена успешно.");
                    } else {
                        System.out.println("Ошибка удаления заявки.");
                    }
                    break;
                case 6:
                    run = false;
                default:
                    System.out.println("Error");
            }

        }
    }

    private void showMenu() {
        String[] menu = {
                "Добавить новую заявку", "Показать все заявки", "Изменить заявку",
                "Удалить заявку", "Показать заявку по id", "Показать заявки по имени",
                "Завершить программу"
        };
        System.out.println("Меню:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}