package ru.collection;

import java.util.List;

public class UsageArrayList {
    public static void main(String[] args) {
        List<String> names = List.of("Petr", "Ivan", "Stepan");
        for (String name : names) {
            System.out.println(name);
        }
    }
}
