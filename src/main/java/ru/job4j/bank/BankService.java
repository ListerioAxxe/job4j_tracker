package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * класс описывает работу банковского приложения
 * которое выполняет определенный набор операций
 * @author Evgen
 * @version 1.0
 */
public class BankService {
    /**
     * Карта которая хранит в себе пользователей и их аккаунты в приложении
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * метод добавляет пользователя в карту , если такого еще нет
     * @param user пользователь который добавляется
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * метод который ищет пользователя по паспорту и
     * добавляет его аккаут (список баланс и реквизиты)
     * @param passport входящий параметр номер паспорта по которму ищем пользователя
     * @param account параметр который добавляем пользователю если он найден
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * метод описывает поиск пользователя по его паспорту
     * @param passport входящий параметр номер паспорта
     * @return возвращает пользователя если таков найден
     */
    public User findByPassport(String passport) {
      return users.keySet()
              .stream()
              .filter(e -> e.getPassport().equals(passport))
              .findFirst()
              .orElse(null);
    }

    /**
     * метод поиска аккаута по реквизитам, сначала находим пользователя по паспорту,
     * и потом сравниваем его реквизиты.
     * @param passport паспорт пользователя для поиска
     * @param requisite реквизиты для поиска
     * @return аккаунт пользователя если реквизиты соответствуют
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user).stream()
                    .filter(s -> s.getRequisite().contains(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * метод перевода денег с одного счета на другой
     * @param srcPassport паспорта клиента с которого уходит перевод
     * @param srcRequisite реквизиты с которых уходит перевод
     * @param destPassport паспорт клиента который получает перевод
     * @param destRequisite реквизиты на которые перевод приходит
     * @param amount сумма перевода ( должна быть меньше или равна балансу
     *               на реквизитах с которых уходит перевод
     * @return вовзращает результат выполнения перевода
     */
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