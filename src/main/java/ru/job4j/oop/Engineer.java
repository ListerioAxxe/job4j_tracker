package ru.job4j.oop;

import java.time.LocalDate;

public class Engineer extends Proffesion {

    private String instrumental;

    public Engineer(String name, String surname, String education, LocalDate birthday, String instrumental) {
      super(name, surname, education, birthday);
      this.instrumental = instrumental;
    }

    public int taskResult(Engineer engineer) {
        return -1;
    }

    public String problems(Engineer engineer) {
        String rsl = "";
        return rsl;
    }


}
