package ru.collection;

import java.util.HashMap;
import java.util.List;

public class OrderConvert {
    public static HashMap<String, Order> process(List<Order> orders) {
        HashMap<String, Order> result = new HashMap<>();
        for (Order order : orders) {
            result.put(order.getNumber(), order);
        }
        return result;
    }
}