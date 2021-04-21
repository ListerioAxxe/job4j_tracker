package ru.job4j.tracker;

public class Bus implements Transport {

    private int passengers;

    @Override
    public void go() {
        int gas = 5;
        int distance = 100;
        int needMoney = gas * distance;
        System.out.println("Необходимая сумма для поездки:  " + needMoney);
    }

    @Override
    public void passengers(int count) {
        this.passengers = count;
    }

    @Override
    public int fuel(int gas) {
        int price = 45;
        return gas*price;
    }
}
