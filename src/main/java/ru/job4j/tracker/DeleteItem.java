package ru.job4j.tracker;

public class DeleteItem implements UserAction{
    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf( input.askStr("Enter ID"));
        if (tracker.delete(id)) {
            System.out.println("Successful");
        } else {
            System.out.println("Error");
        }
        return true;
    }
}
