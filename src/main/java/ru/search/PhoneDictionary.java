package ru.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список пользователей, которые прошли проверку.
     */
    public ArrayList<Person> find(String key) {
        var nameContains = (Predicate<Person>) person -> person.getName().contains(key);
        var surnameContains = (Predicate<Person>) person -> person.getSurname().contains(key);
        var phoneContains = (Predicate<Person>) person -> person.getPhone().contains(key);
        var addressContains = (Predicate<Person>) person -> person.getAddress().contains(key);
        var combine = nameContains.or(surnameContains).or(phoneContains).or(addressContains);
        var result = new ArrayList<Person>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}