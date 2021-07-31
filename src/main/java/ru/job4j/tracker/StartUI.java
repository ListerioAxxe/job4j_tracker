package ru.job4j.tracker;

import java.util.ArrayList;

public class StartUI {
    private final Output out;
    private final Input input;
    private final Store tracker;
    private final ArrayList<UserAction> actions;

    public StartUI(Output out, Input input, Store tracker, ArrayList<UserAction> actions) {
        this.out = out;
        this.input = input;
        this.tracker = tracker;
        this.actions = actions;
        init();
    }

    public void init() {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker, out);
        }
    }

    private void showMenu(ArrayList<UserAction> actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) throws Exception {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        try (Store tracker = new MemTracker()) {
            tracker.init();
            ArrayList<UserAction> actions = new ArrayList<>();
            actions.add(new CreateAction());
            actions.add(new ShowAllItem());
            actions.add(new EditItem());
            actions.add(new DeleteItem());
            actions.add(new FindById());
            actions.add(new FindByName());
            actions.add(new ExitAction());
            actions.add(new GCTestAction(output));
            new StartUI(output, input, tracker, actions);
        }
    }
}