package ru.job4j.tracker;

public class EditItem implements  UserAction {
    @Override
    public String name() {
        return "Edit Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Output out) {
        int id = input.askInt("Enter ID");
        String name =  input.askStr("Enter name ");
        Item first = new Item(name);
        if (tracker.replace(id, first)) {
            out.println("Successful");
        } else {
            out.println("Error");
        }
        return true;
    }
}
