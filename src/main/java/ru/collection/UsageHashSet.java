package ru.collection;

import java.util.HashSet;
import java.util.List;

public class UsageHashSet {
    public static void main(String[] args) {
        HashSet<String> autos = new HashSet<>(List.of("Lada", "BMW", "Volvo", "Toyota"));
        for (String auto : autos) {
            System.out.println(auto);
        }
    }
}