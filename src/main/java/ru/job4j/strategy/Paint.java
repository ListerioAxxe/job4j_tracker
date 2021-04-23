package ru.job4j.strategy;

public class Paint {
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Paint context = new Paint();
        Shape triangle = new Triangle();
        Shape square = new Square();
        context.draw(new Square());
        context.draw(new Triangle());

    }
}
