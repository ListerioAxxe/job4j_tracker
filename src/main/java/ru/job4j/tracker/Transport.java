package ru.job4j.tracker;

public interface Transport {
    void go();

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    void passengers(int count);

    int fuel(int gas);

}
