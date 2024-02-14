package ru.bank;

import java.util.Objects;

/**
 * Класс описывает модель пользователя банка.
 *
 * @author Timofey Nikitan
 * @version 1.0
 */
public class User {
    /**
     * Поле паспорт клиента.
     */
    private String passport;
    /**
     * Поле имя клиента.
     */
    private String username;

    /**
     * Конструктор - создание нового объекта User.
     *
     * @param passport - паспорт клиента.
     * @param username - имя клиента.
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Функция получения значения поля {@link User#passport}
     *
     * @return возвращает паспорт клиента.
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Функция установления значения поля {@link User#passport}
     *
     * @param passport - паспорт клиента.
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Функция получения значения поля {@link User#username}
     *
     * @return возвращает имя клиента.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Функция установления значения поля {@link User#username}
     *
     * @param username - имя клиента.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Функция сравнивает два объекта по полю паспорт.
     *
     * @param o - объект, с которым производится сравнение.
     * @return возвращает true либо false в случае равенства или неравенства объектов соответственно.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Функция генерирует хэш-код объекта User.
     *
     * @return возвращает хэш-код объекта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}