package ru.job4j.oop;

import java.time.LocalDate;

public class Electric extends Engineer {

    private int experience;

    public Electric(String name, String surname, String education,
                    LocalDate birthday, String instrumental, int experience) {
        super(name, surname, education, birthday, instrumental);
        this.experience = experience;
    }

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    public int taskCompete(Electric electric) {
        return -1;
    }
}

