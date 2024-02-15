package ru.collection;

import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> departments) {
        Set<String> temp = new LinkedHashSet<>();
        for (String department : departments) {
            StringBuilder current = new StringBuilder();
            for (String dep : department.split("/")) {
                current.append(dep);
                temp.add(current.toString());
                current.append("/");
            }
        }
        return new ArrayList<>(temp);
    }


    public static void sortAsc(List<String> departments) {
        Collections.sort(departments);
    }

    public static void sortDesc(List<String> departments) {
        Collections.sort(departments, new DepartmentsDescComparator());
    }
}