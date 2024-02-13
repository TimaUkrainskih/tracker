package ru.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemDescByNameTest {
    @Test
    public void thenItemDescByName() {
        List<Item> items = Arrays.asList(new Item("main"), new Item("test"), new Item("aaa"), new Item("name"));
        Collections.sort(items, new ItemDescByName());
        List<Item> expected = Arrays.asList(new Item("test"), new Item("name"), new Item("main"), new Item("aaa"));
        assertThat(items).containsAll(expected);
    }
}