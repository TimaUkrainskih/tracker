package ru.bank;

import java.util.Objects;

/**
 * Класс описывает модель банковского счета.
 *
 * @author Timofey Nikitan
 * @version 1.0
 */
public class Account {
    /**
     * Поле реквизиты счета.
     */
    private String requisite;
    /**
     * Поле баланс счета.
     */
    private double balance;

    /**
     * Конструктор - создание нового объекта Account.
     *
     * @param requisite - реквизиты счета.
     * @param balance   - реквизиты счета.
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Функция получения значения поля {@link Account#requisite}
     *
     * @return возвращает реквизиты счета.
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Функция установления значения поля {@link Account#requisite}
     *
     * @param requisite - реквизиты счета.
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Функция получения значения поля {@link Account#balance}
     *
     * @return возвращает баланс счета.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Функция установления значения поля {@link Account#balance}
     *
     * @param balance - реквизиты счета.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Функция сравнивает два объекта по полю реквизиты.
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Функция генерирует хэш-код объекта Account.
     *
     * @return возвращает хэш-код объекта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}