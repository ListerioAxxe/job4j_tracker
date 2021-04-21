package ru.job4j.tracker;

public class Bus implements Transport {
    @Override
    public void go() {
        int gas = 5;
        int distance = 100;
        int needMoney = gas * distance;
    }

    @Override
    public void passengers(int count) {
        int passengr = count;
    }

    @Override
    public int fuel(int gas) {
        int price = 45;
        return gas*price;
    }
}
