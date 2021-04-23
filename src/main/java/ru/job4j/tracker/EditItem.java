package ru.job4j.tracker;

public class EditItem implements  UserAction{
    @Override
    public String name() {
        return "Edit Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf( input.askStr("Enter ID"));
        String name =  input.askStr("Enter name ");
        Item first = new Item(name);
        if (tracker.replace(id, first)) {
            System.out.println("Successful");
        } else {
            System.out.println("Error");
        }
        return true;
    }
}
