package ru.job4j.tracker;

import java.util.Arrays;


public class StartUI {

    public static void  createItem (Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name =  input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showAllItem (Tracker tracker) {
        Item[] find = tracker.findAll();
        System.out.println(Arrays.toString(find));
    }

    public static void  editItem (Input input, Tracker tracker) {
        int id = Integer.valueOf( input.askStr("Enter ID"));
        String name =  input.askStr("Enter name ");
        Item first = new Item(name);
        if (tracker.replace(id, first)) {
            System.out.println("Successful");
        } else {
            System.out.println("Error");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        int id = Integer.valueOf( input.askStr("Enter ID"));
        if (tracker.delete(id)) {
            System.out.println("Successful");
        } else {
            System.out.println("Error");
        }
    }
    public static void findById (Input input, Tracker tracker) {
        int id = Integer.valueOf( input.askStr("Enter ID"));
        Item second = tracker.findById(id);
        if (second != null) {
            System.out.println(second);
        }
        else {
            System.out.println("Заявка с таким ID не найдена");
        }
    }

    public static void findByName(Input input, Tracker tracker) {
        String name =  input.askStr("Enter name");
        Item[] rsl = tracker.findByName(name);
        if (rsl.length > 0) {
            System.out.println(Arrays.toString(rsl));
        }
        else {
            System.out.println("Заявка с таким именем не найдены");
        }
    }


    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf( input.askStr("Select"));
              if (select == 0) {
                 StartUI.createItem(input, tracker);
              }
              else if ( select == 1) {
                  StartUI.showAllItem(tracker);
              }
              else if (select == 2) {
                  StartUI.editItem(input, tracker);
              }
              else if (select == 3) {
                StartUI.deleteItem(input, tracker);
              }
              else if (select == 4) {
                  StartUI.findById(input, tracker);
              }
             else if (select == 5) {
                 StartUI.findByName(input, tracker);
              }
             else if (select == 6) {
                 run = false;
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
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}