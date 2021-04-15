package ru.job4j.inheritance;

public class ReportUsage {

    public static void main(String[] args) {
        JSONReport report = new JSONReport();
        String rsl = report.generate("name", "body");
        System.out.println(rsl);
    }
}
