package ru.search;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Ivan", "Ivanov", "534872", "Bryansk")
        );
        var persons = phones.find("Ivan");
        assertThat(persons.get(0).getSurname()).isEqualTo("Ivanov");
    }

    @Test
    public void whenNoFinding() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Ivan", "Ivanov", "534872", "Bryansk")
        );
        var persons = phones.find("navI");
        assertThat(persons).isEmpty();
    }
}