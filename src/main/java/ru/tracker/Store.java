package ru.tracker;

import java.util.List;

public interface Store extends AutoCloseable {

    Item add(Item item);

    boolean replace(int id, Item item);

    void delete(int id);

    List<Item> findAll();

    List<Item> findByName(String key);

    Item findById(int id);
}