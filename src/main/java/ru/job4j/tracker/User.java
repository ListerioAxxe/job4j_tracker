package ru.job4j.tracker;

import java.util.Comparator;
import java.util.Objects;

public class User implements Comparable<User> {
    private int id;
    private String username;
    private String password;
    private int age;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(String username, int id) {
        this.id = id;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id == user.id && age == user.age && Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, age);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int compareTo(User o) {
       int rsl =  this.getUsername().compareTo(o.getUsername());
       if (rsl == 0) {
           return Integer.compare(this.getAge(), o.getAge());
       }
       return rsl;

      // или так return  Comparator.comparing(User::getUsername).thenComparing(User::getAge).compare(this, o);
    }
}