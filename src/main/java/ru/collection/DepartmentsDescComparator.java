package ru.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String leftA = left.split("/")[0];
        String rightA = right.split("/")[0];
        if (rightA.compareTo(leftA) == 0) {
            return left.compareTo(right);
        }
        return right.compareTo(left);
    }
}
