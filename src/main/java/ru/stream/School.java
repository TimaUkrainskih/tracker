package ru.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predicate) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (predicate.test(student)) {
                result.add(student);
            }
        }
        return result;
    }
}