package ru.job4j.inheritance;

public class HtmlReport extends TextReport {

     @Override
    public String generate(String name, String body) {
        return "<h1>" + name + "</h1>" +
                "<br/>" +
                "<span>" + body + "</span>";
    }

    public static void main(String[] args) {
        System.out.println("Java said, \"Hello World!\"");
    }
}