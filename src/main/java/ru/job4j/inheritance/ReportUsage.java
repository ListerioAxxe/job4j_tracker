package ru.job4j.inheritance;

public class ReportUsage {

    public static void main(String[] args) {
        JSONReport report = new JSONReport();
        String rsl = report.generate("name", "body");
        System.out.println(rsl);
        System.out.println();

        HtmlReport htmlReport = new HtmlReport();
        String text = report.generate("sdh", "sdhb");
        System.out.println(text);

    }
}
