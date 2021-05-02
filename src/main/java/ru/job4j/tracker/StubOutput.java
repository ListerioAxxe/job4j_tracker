package ru.job4j.tracker;

public class StubOutput implements Output {
    private final StringBuilder buffer = new StringBuilder();

    @Override
    public void println(String string) {
        if (string != null) {
            buffer.append(string);
        } else {
            buffer.append("null");
        }
        buffer.append(System.lineSeparator());
    }

    @Override
    public String toString() {
        return buffer.toString();
    }
}