package ru.stream;

import java.util.Arrays;
import java.util.List;

public class MatrixToList {

    public static List<Integer> convert(Integer[][] matrix) {
        return Arrays.stream(matrix)
                .flatMap(element -> Arrays.stream(element))
                .toList();
    }
}