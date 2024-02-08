package ru.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsageArrayList {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Petr", "Ivan", "Stepan"));
        for (String name : names) {
            System.out.println(name);
        }
    }
}
