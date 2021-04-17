package ru.job4j.pojo;

import java.util.function.LongUnaryOperator;

public class Library {
    public static void main(String[] args) {
        Book first = new Book("Clean code", 5);
        Book second = new Book("Java rush", 3);
        Book third = new Book("Programmer", 6);
        Book four = new Book("Right now", 2);
        Book[] libr = new Book[4];
        libr[0] = first;
        libr[1] = second;
        libr[2] = third;
        libr[3] = four;

        for (int i = 0; i < libr.length; i++) {
            Book p = libr[i];
            System.out.println(p.getName() + " " + p.getCount());
        }

        System.out.println("Replace 0 index to 3");
        Book tmp = libr[3];
        libr[3] = libr[0];
        libr[0] = tmp;

        for (int index = 0; index < libr.length; index++) {
            Book rsl = libr[index];
            System.out.println(rsl.getName() + " - " + rsl.getCount());
        }

        System.out.println();
        System.out.println("Show \"Clean code\" ");

        for (int s = 0; s < libr.length; s++) {
            Book resl = libr[s];
            if (resl.getName().equals("Clean code")) {
                System.out.println(resl.getName() + " " + resl.getCount());
            }
        }
    }
}
