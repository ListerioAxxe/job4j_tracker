package ru.job4j.tracker;

public class FindById implements UserAction {
    private final Output out;

    public FindById(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by ID";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf( input.askStr("Enter ID"));
        Item second = tracker.findById(id);
        if (second != null) {
            out.println(second);
        } else {
            out.println("Заявка с таким ID не найдена");
        }
        return true;
    }
}
