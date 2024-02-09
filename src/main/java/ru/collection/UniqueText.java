package ru.collection;

import java.util.Arrays;
import java.util.HashSet;

public class UniqueText {
    public boolean isEquals(String originText, String duplicateText) {
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>(Arrays.asList(origin));
        int count = 0;
        for (String word : text) {
            if (check.contains(word)) {
                count++;
            }
        }
        return count == origin.length;
    }
}