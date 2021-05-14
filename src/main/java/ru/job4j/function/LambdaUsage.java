package ru.job4j.function;

import java.util.Comparator;

@SuppressWarnings("checkstyle:EmptyLineSeparator")
public class LambdaUsage {
    public static void main(String[] args) {

       Comparator<String> cmpText1 = (left, right) -> {
          System.out.println("compare - " + left.length() + " : " + right.length());
         return Integer.compare(left.length(), right.length());
      };

        Comparator<String> cmpDescSize1 = (left, right) -> {
           System.out.println("compare - " + left.length() + " : " + right.length());
           return right.length() - left.length();
        };
    }
}
