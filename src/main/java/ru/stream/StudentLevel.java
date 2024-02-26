package ru.stream;

import java.util.List;
import java.util.stream.Stream;

public class StudentLevel {
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .sorted((x, y) -> Integer.compare(y.getScore(), x.getScore()))
                .takeWhile(x -> x.getScore() >= bound)
                .toList();

    }
}