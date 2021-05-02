package ru.job4j.tracker;

public class DeleteItem implements UserAction{
    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Output out) {
        int id = input.askInt("Enter ID");
        if (tracker.delete(id)) {
            out.println("Successful");
        } else {
            out.println("Error");
        }
        return true;
    }
}
