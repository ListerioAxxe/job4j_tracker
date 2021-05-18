package ru.job4j.bank;

import java.util.*;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
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
    public Optional<User> findByPassport(String passport) {
      return users.keySet()
              .stream()
              .filter(e -> e.getPassport().equals(passport))
              .findFirst();
    }

    /**
     * метод поиска аккаута по реквизитам, сначала находим пользователя по паспорту,
     * и потом сравниваем его реквизиты.
     * @param passport паспорт пользователя для поиска
     * @param requisite реквизиты для поиска
     * @return аккаунт пользователя если реквизиты соответствуют
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            Optional<Account> use = users.get(user.get()).stream()
                    .filter(s -> s.getRequisite().contains(requisite))
                    .findFirst();
        }
        return Optional.empty();
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
       Optional<Account> scrAcc = findByRequisite(srcPassport, srcRequisite);
       Optional<Account> destAcc = findByRequisite(destPassport, destRequisite);
       if (scrAcc.isPresent() && destAcc.isPresent() && scrAcc.get().getBalance() >= amount) {
           scrAcc.get().setBalance(scrAcc.get().getBalance() - amount);
           destAcc.get().setBalance(destAcc.get().getBalance() + amount);
           return true;
       }
        return false;
    }
}