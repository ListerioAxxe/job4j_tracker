package ru.job4j.ex;

public class FindEl {

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        int count = 0;
        for (String s : value) {
            if (s.equals(key)) {
                rsl = count;
                break;
            }
            count++;
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Not found");
        }
        return rsl;
    }

    public static void main(String[] args) throws  ElementNotFoundException {
        try {
            indexOf(new String[]{"1", "2", "3"}, "4");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}