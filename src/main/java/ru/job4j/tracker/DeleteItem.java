package ru.job4j.tracker;

public class DeleteItem implements UserAction{
    private final Output out;

    public DeleteItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter ID");
        if (tracker.delete(id)) {
            out.println("Successful");
        } else {
            out.println("Error");
        }
        return true;
    }
}
