package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        String rsl = "Неизвестное слово: ";
        return rsl + eng;
    }

    public static void main(String[] args) {
            DummyDic end = new DummyDic();
            System.out.println(end.engToRus("lol"));
    }
}
