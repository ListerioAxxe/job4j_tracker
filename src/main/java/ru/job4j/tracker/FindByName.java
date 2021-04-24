package ru.job4j.tracker;

import java.util.Arrays;

public class FindByName implements  UserAction{
    private final Output out;

    public FindByName(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by Name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name =  input.askStr("Enter name");
        Item[] rsl = tracker.findByName(name);
        if (rsl.length > 0) {
            out.println(Arrays.toString(rsl));
        } else {
            out.println("Заявка с таким именем не найдены");
        }
        return true;
    }
}
