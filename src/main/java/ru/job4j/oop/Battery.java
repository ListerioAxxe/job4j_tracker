package ru.job4j.oop;

public class Battery {

    private int load; // создали поле заряд батареи

    public Battery(int accum) {  // конструктор Батарея входящий параметр заряда
        this.load = accum;        // обратились к полю , передали параметр заряда в поле
    }

    public void exchange(Battery another) {   // метод обмена зарядом
        another.load = this.load + another.load;  // в поле сумму зарядов обоих батарей (обращаемся к полю
        this.load = 0;  // батарея пуста
    }

    public static void main(String[] args) {
        Battery first = new Battery(15);
        Battery second = new Battery(10);
        first.exchange(second);
        System.out.println("first " + first.load + " second " + second.load );
    }
}
