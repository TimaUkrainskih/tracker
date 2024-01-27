package ru.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        System.out.println(formatter.format(item.getCreated()));
        item.setId(1);
        item.setName("First");
        System.out.println(item);
    }
}
