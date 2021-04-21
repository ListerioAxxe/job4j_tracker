package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.println("Select:");
            int select = Integer.valueOf(scanner.nextLine());
              if (select == 0) {
                  System.out.println("=== Create a new Item ====");
                  System.out.print("Enter name: ");
                  String name = scanner.nextLine();
                  Item item = new Item(name);
                  tracker.add(item);
              }
              else if ( select == 1) {
                  Item[] find = tracker.findAll();
                  System.out.println(Arrays.toString(find));
              }
              else if (select == 2) {
                  System.out.println("Enter ID");
                  int id = Integer.valueOf(scanner.nextLine());
                  System.out.println("Enter name");
                  String name = scanner.nextLine();
                  Item first = new Item(name);
                  if (tracker.replace(id, first)) {
                      System.out.println("Successful");
                  } else {
                      System.out.println("Error");
                  }
              }
              else if (select == 3) {
                  int id = Integer.valueOf(scanner.nextLine());
                  if (tracker.delete(id)) {
                      System.out.println("Successful");
                  } else {
                      System.out.println("Error");
                  }
              }
              else if (select == 4) {
                  int id = Integer.valueOf(scanner.nextLine());
                  Item second = tracker.findById(id);
                 if (second != null) {
                     System.out.println(second);
                 }
                 else {
                     System.out.println("Заявка с таким ID не найдена");
                 }
              }
             else if (select == 5) {
                  String name = scanner.nextLine();
                  System.out.println("Введите имя заявки для поиска");
                  Item[] rsl = tracker.findByName(name);
                    if (rsl.length > 0) {
                        System.out.println(Arrays.toString(rsl));
                    }
                    else {
                        System.out.println("Заявка с таким именем не найдены");
                    }
              }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);

    }
}