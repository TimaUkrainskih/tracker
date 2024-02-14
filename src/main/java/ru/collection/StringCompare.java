package ru.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        for (int i = 0; i < left.length(); i++) {
            int compareChar = Character.compare(left.charAt(i), right.charAt(i));
            if (compareChar != 0) {
                return compareChar;
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}