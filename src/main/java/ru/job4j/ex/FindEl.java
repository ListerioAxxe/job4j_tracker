package ru.job4j.ex;

public class FindEl {

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                if (!key.equals(value[i])) {
                    throw new ElementNotFoundException("Element not found");
                }
                rsl = i;
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            indexOf(new String[]{"first", "second", "third"}, "l");
        }  catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}