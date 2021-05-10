package ru.job4j.collection;

import java.util.*;

/**
 * данный класс сортирует департаменты отделений
 */

public class Departments {
    /**
     * метод добавляет недостающие элементы департаментов
     * сначала создаем карту, чтоб она автоматически сортировала
     * повторяющиеся элементы
     * проходим циклом по списку,
     * стартоввый элемент задали,
     * и отдельно проходим по элементам списка разбивая их
     * на отдельные департаменты , проходимся по ним
     * а дальше каждый элемент добавляется к предыдущему,
     * @param deps входящий список департаментов
     * @return возвращает отредактированный список с аргументом
     * временной карты
     */
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
              start = start.equals("") ? el : start + "/" + el;
              tmp.add(start);
            }
        }
        return new ArrayList<>(tmp);
    }

    /**
     * сортируем список (сортируем по возрастанию встроенным методом)
     * @param orgs сортируемый список
     */
    public static List<String> sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
        return orgs;
    }

    /**
     * cортируем список  убыванию, компаратор написали
     * @param orgs сортируемый список
     */
    public static List<String> sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
        return orgs;
    }
}