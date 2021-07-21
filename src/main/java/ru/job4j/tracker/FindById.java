package ru.job4j.tracker;

public class FindById implements UserAction {
    @Override
    public String name() {
        return "Find by ID";
    }

    @Override
    public boolean execute(Input input, Store tracker, Output out) {
        int id = input.askInt("Enter ID");
        Item second = tracker.findById(id);
        if (second != null) {
            out.println(second.toString());
        } else {
            out.println("Заявка с таким ID не найдена");
        }
        return true;
    }
}
