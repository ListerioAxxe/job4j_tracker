package ru.job4j.oop;

import java.time.LocalDate;

public class Lor extends Doctor {

    private int cabinet;

    public Lor(String name, String surname, String education,
               LocalDate birthday, String classification, int cabinet) {
        super(name, surname, education, birthday, classification);
        this.cabinet = cabinet;
    }

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    public int numberHealed(Lor lor) {
        return -1;
    }

    public String needEquipment(Lor lor) {
        return "";
    }
}
