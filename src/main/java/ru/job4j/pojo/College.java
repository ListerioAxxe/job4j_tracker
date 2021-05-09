package ru.job4j.pojo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Ivan");
        student.setGroup(28);
        student.setData(new Date());
        System.out.println(student.getName() + " "
                + student.getGroup() + " group " + student.getData());
    }
}
