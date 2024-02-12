package ru.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public boolean addUser(User user) {
        if (!users.containsKey(user)) {
            users.put(user, new ArrayList<>());
        }
        return false;
    }

    public boolean deleteUser(String passport) {
        User user = findByPassport(passport);
        if (user != null) {
            users.remove(user);
            return true;
        }
        return false;
    }

    public boolean addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        Account userAccount = findByRequisite(passport, account.getRequisite());
        if (user != null && userAccount == null) {
            users.get(user).add(account);
            return true;
        }
        return false;
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

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

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}