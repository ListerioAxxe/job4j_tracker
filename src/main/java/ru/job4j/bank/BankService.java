package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
      for (User user : users.keySet()) {
          if (user != null) {
              if (user.getPassport().equals(passport)) {
                  return user;
              }
          }
      }
      return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
        for (Account account : users.get(user)) {
            if (account.getRequisite().contains(requisite)) {
                return account;
            }
        }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
       Account scrAcc = findByRequisite(srcPassport, srcRequisite);
       Account destAcc = findByRequisite(destPassport, destRequisite);
       if (scrAcc != null && destAcc != null && scrAcc.getBalance() >= amount) {
           scrAcc.setBalance(scrAcc.getBalance() - amount);
           destAcc.setBalance(destAcc.getBalance() + amount);
           return true;
       }
        return false;
    }
}