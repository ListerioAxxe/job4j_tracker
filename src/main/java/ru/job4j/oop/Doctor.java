package ru.job4j.oop;

import com.sun.source.doctree.DocTree;

import javax.print.Doc;
import java.time.LocalDate;

public class Doctor extends Proffesion {

    private String classification;

    public Doctor(String name, String surname, String education,
                  LocalDate birthday, String classification) {
        super(name, surname, education, birthday);
        this.classification = classification;
    }

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    public String journalPacient(Doctor doctor) {
        String rsl = "";
        return rsl;
    }

    public int pacientNumber(Doctor doctor) {
        return -1;
    }

}


