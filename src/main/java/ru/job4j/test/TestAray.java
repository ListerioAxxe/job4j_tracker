package ru.job4j.test;

public class TestAray {
        public static boolean checkArray(int[] data) {
            int rsl = 0;
            for (var rl : data) {
                rsl  += rl;
            }
            if (rsl % 2 == 0) {
                return true;
            }
            return false;
        }
    }

