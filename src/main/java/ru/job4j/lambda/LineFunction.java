package ru.job4j.lambda;

import java.util.function.Function;

public class LineFunction {

    public static double calculate(double x) {
        return calculate(num -> num * 2 + 1, x);
    }

    public static double calculate(Function<Double, Double> y, double x) {
        return y.apply(x);
    }
}
