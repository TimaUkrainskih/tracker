package ru.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        Map<String, String> userData = new HashMap<>();
        userData.put("qwerty@mail.ru", "Ivanov Ivan");
        userData.put("tach@list.ru", "Ivanova Maria");
        userData.put("root@icloud.ru", "Kuznetsov Ivan");
        for (String key : userData.keySet()) {
            System.out.println(key + " = " + userData.get(key));
        }

    }
}
