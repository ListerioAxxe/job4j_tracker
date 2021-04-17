package ru.job4j.pojo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Student {
    private String name;
    private int group;
    private Date data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}