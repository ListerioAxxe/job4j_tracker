package ru.job4j.oop;

public class Cat {

    private String food; //поле обьекта
    private String name;  //поле обьекта

    public void giveNick(String nick) {
        this.name = nick;  // обращаемся к полю, присваиваем ему значение входящего параметра метода
    }

    public void eat(String meat) {
        this.food = meat;   // обращаемся к полю,
        // присваиваем ему значение входящего параметра метода
    }

    public void show() {   // метод выводит результат обращения к
        // полям, которые мы проинициализировали
        System.out.println(this.food); // выводим на экран обращение к полю
        System.out.println(this.name); // выводим на экран обращение к полю
    }

    public static void main(String[] args) {
        System.out.println("There are gav's food.");
        Cat gav = new Cat();  // создаем обьект из класса
        gav.eat("kotleta"); // обращаемся к обьекту с вызовом метода и входящим параметром
        gav.giveNick("gav"); // обращаемся к обьекту с вызовом метода и входящим параметром
        gav.show();  // обращение к обьекту с вызовом метода
        System.out.println("There are black's food.");
        Cat black = new Cat(); // создаем обьект из класса
        black.eat("fish"); // обращаемся к обьекту с вызовом метода и входящим параметром
        black.giveNick("black"); // обращаемся к обьекту с вызовом метода и входящим параметром
        black.show(); // обращение к обьекту с вызовом метода
    }
}