package ru.job4j.oop;

import java.time.LocalDate;

public class Proffesion {

    private String name;
    private String surname;
    private String education;
    private LocalDate birthday;

    public String getName() {return name;}
    public String getSurname() {return surname;}
    public String getEducation() {return education;}
    public LocalDate getBirthday() {return birthday;}

    public Proffesion (String name, String surname, String education, LocalDate birthday) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
    }



}
