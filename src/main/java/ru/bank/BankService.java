package ru.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает простейшую модель банковской системы.
 *
 * @author Timofey Nikitan
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение пользователей банка и их банковских счетов осуществляется в коллекции типа HashMap.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и добавляет его в систему,
     * помещая в HashMap пару <Пользователь, Банковские счета>.
     * Добавление пользователя происходит успешно в случае, если его еще нет в системе.
     *
     * @param user пользователь, которого нужно добавить.
     * @return возвращает true, если пользователь успешно добавлен и false в противном случае.
     */
    public boolean addUser(User user) {
        if (!users.containsKey(user)) {
            users.put(user, new ArrayList<>());
            return true;
        }
        return false;
    }

    /**
     * Метод принимает на вход паспорт пользователя, находит и удаляет из HashMap.
     * Удаление проходи успешно в случае, если такой клиент существует в системе.
     *
     * @param passport паспорт клиента, по котором производится поиск и последующее удаление.
     * @return возвращает true, в случае, если пользователь есть в системе и false в противном случае.
     */
    public boolean deleteUser(String passport) {
        User user = findByPassport(passport);
        if (user != null) {
            users.remove(user);
            return true;
        }
        return false;
    }

    /**
     * Метод принимает на вход паспорт клиента и его банковский счет,
     * ищет по паспорту пользователя и добавляет к нему новый счет.
     * Добавление происходит успешно в случае, если пользователь зарегистрирован в системе
     * и новый счет не дублирует уже существующие.
     *
     * @param passport паспорт клиента.
     * @param account  банковский счет.
     * @return возвращает true, если данные добавлены успешно и false в противном случае.
     */
    public boolean addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        Account userAccount = findByRequisite(passport, account.getRequisite());
        if (user != null && userAccount == null) {
            users.get(user).add(account);
            return true;
        }
        return false;
    }

    /**
     * Метод принимает на вход паспорт клиента и осуществляет его поиск в HashMap.
     *
     * @param passport паспорт клиента.
     * @return возвращает объект пользователя User, если он есть в системе и null при его отсутствии.
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод принимает на вход паспорт клиента и его реквизиты банковского счета,
     * ищет по паспорту пользователя и возвращает банковский счет, соответсвующий реквизитам.
     *
     * @param passport  паспорт клиента.
     * @param requisite реквизиты счета.
     * @return возвращает объект банковский счет Account, соответсвующий реквизита в успешном случае и null в противном.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод принимает на вход данные пользователя или пользователей для осуществления перевода денег между счетами.
     *
     * @param sourcePassport       паспорт клиента, со счета которого будет производиться списывание средств.
     * @param sourceRequisite      реквизиты счета, с которого произведется списывание средств.
     * @param destinationPassport  паспорт клиента, на счет которого поступят средства.
     * @param destinationRequisite реквизиты счета, на который поступят средства.
     * @param amount               количество средств, которые будут участвовать в трансфере.
     * @return возвращает true, если счета с такими паспортными данными и реквизитами существуют
     * и false в противном случае.
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (sourceAccount != null && destinationAccount != null && sourceAccount.getBalance() >= amount) {
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            destinationAccount.setBalance(destinationAccount.getBalance() + amount);
            return true;
        }
        return false;
    }

    /**
     * Метод принимает на вход клиента и возвращает список его банковских счетов.
     *
     * @param user пользователь, счета которого нужно получить
     * @return возвращает список счетов, принадлежащих клиенту
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}