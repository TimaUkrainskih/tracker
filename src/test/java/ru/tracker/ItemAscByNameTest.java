package ru.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemAscByNameTest {
    @Test
    public void thenItemAscByName() {
        List<Item> items = Arrays.asList(new Item("main"), new Item("test"), new Item("aaa"), new Item("name"));
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = Arrays.asList(new Item("aaa"), new Item("main"), new Item("name"), new Item("test"));
        assertThat(items).containsAll(expected);
    }
}