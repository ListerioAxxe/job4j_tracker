package ru.job4j.tracker;

import java.util.Arrays;
import java.util.List;

public class FindByName implements  UserAction {
    @Override
    public String name() {
        return "Find by Name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Output out) {
        String name =  input.askStr("Enter name");
        List<Item> rsl = tracker.findByName(name);
        if (rsl.size() > 0) {
            for (Item item : rsl) {
                out.println(item.toString());
            }
        } else {
            out.println("Заявка с таким именем не найдены");
        }
        return true;
    }
}
